package com.sup.core.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sup.core.exceptions.FileNotFoundException;
import com.sup.core.exceptions.StorageException;

@Service
@ConfigurationProperties(prefix = "storage")
public class FileSystemStorageService {

//     private String location;

//     private Path rootLocation;

//     private Date today = new Date();

//     public FileSystemStorageService() {
//     }

//     @PostConstruct
//     public void init() {
//         try {
//             rootLocation = Paths.get(location);
//             Files.createDirectories(rootLocation);
//         } catch (IOException e) {
//             throw new StorageException("Could not initialize storage location", e);
//         }
//     }

//     public String getLocation() {
//         return location;
//     }

//     public void setLocation(String location) {
//         this.location = location;
//     }

//     public String getRandomFilename() {
//         today = new Date();
//         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-SSS");
//         return sdf.format(today);
//     }

//     public Path load(String filename) {
//         return rootLocation.resolve(filename);
//     }

//     public Path loadFromSection(String filename, String section, Long referenceId) {
//         try {

//             rootLocation = Paths.get(location + File.separator + section + File.separator + referenceId);

//             return rootLocation.resolve(filename);
//         } catch (Exception e) {
//             System.err.println(e);
//         }
//         return rootLocation.resolve(filename);
//     }

//     public Resource loadAsResource(String filename, String section) {
//         try {
//             rootLocation = Paths.get(location + File.separator + section);
//             Path file = load(filename);
//             Resource resource = new UrlResource(file.toUri());
//             if (resource.exists() || resource.isReadable()) {
//                 return resource;
//             } else {
//                 throw new FileNotFoundException("Could not read file: " + filename);
//             }
//         } catch (MalformedURLException e) {
//             throw new FileNotFoundException("Could not read file: " + filename, e);
//         }
//     }

//     public Resource loadAsResourceProfilePicture(String filename, String section) {
//         try {
//             rootLocation = Paths.get(location + File.separator + section);
//             Path file = load(filename);
//             Resource resource = new UrlResource(file.toUri());
//             if (resource.exists() || resource.isReadable()) {
//                 return resource;
//             } else {
//                 throw new FileNotFoundException("Could not read file: " + filename);
//             }
//         } catch (MalformedURLException e) {
//             throw new FileNotFoundException("Could not read file: " + filename, e);
//         }
//     }

//     public String getFileExtension(MultipartFile multipartFile) {
//         return FilenameUtils.getExtension(multipartFile.getOriginalFilename());
//     }

//     public String storeFileTest(MultipartFile file) {
//         // Normalize file name
//         String fileName = StringUtils.cleanPath(file.getOriginalFilename());

//         try {
//             // Check if the file's name contains invalid characters
//             if (fileName.contains("..")) {
//                 throw new StorageException("Sorry! Filename contains invalid path sequence " + fileName);
//             }

//             // Copy file to the target location (Replacing existing file with the same name)
//             Path targetLocation = this.rootLocation.resolve(fileName);
//             Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

//             return fileName;
//         } catch (IOException ex) {
//             throw new StorageException("Could not store file " + fileName + ". Please try again!", ex);
//         }
//     }

//     public Resource loadAsResourceAudioFile(String filename, String section) {
//         try {
//             rootLocation = Paths.get(location + File.separator);
//             Path file = load(filename);
//             Resource resource = new UrlResource(file.toUri());
//             if (resource.exists() || resource.isReadable()) {
//                 return resource;
//             } else {
//                 throw new FileNotFoundException("Could not read file: " + filename);
//             }
//         } catch (MalformedURLException e) {
//             throw new FileNotFoundException("Could not read file: " + filename, e);
//         }
//     }
}
