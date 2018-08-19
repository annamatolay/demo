package com.palmatolay.basic

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import java.io.IOException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/users/{id}")
class UserController {
    private val logger = LoggerFactory.getLogger(UserController::class.java)

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var fileStorageService: FileStorageService

    @GetMapping
    fun readUser(@PathVariable("id") id: Long) = userRepository.findById(id)

    @PutMapping
    fun updateUser(@PathVariable("id") id: Long, @RequestBody data: User): User {
        userRepository.deleteById(id)
        return userRepository.save(data)
    }

    @DeleteMapping
    fun deleteUser(@PathVariable("id") id: Long) = userRepository.deleteById(id)

    @PostMapping("/avatar")
    fun uploadAvatar(@PathVariable("id") id: Long, @RequestParam("file") file: MultipartFile): UploadFileResponse {
        val fileName = fileStorageService.storeFile(file)

        val fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/$id/")
                .path(fileName)
                .toUriString()

        return UploadFileResponse(fileName, fileDownloadUri,
                file.contentType, file.size)
    }

    @GetMapping("/avatar")
    fun downloadAvatar(@PathVariable("id") id: Long, request: HttpServletRequest): ResponseEntity<Resource> {
        // Load file as Resource
        val resource = fileStorageService.loadFileAsResource("avatar.png")

        // Try to determine file's content type
        var contentType: String? = null
        try {
            contentType = request.servletContext.getMimeType(resource.file.absolutePath)
        } catch (ex: IOException) {
            logger.info("Could not determine file type.")
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream"
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.filename + "\"")
                .body<Resource>(resource)
    }
}
