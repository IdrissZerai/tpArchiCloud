package com.example.videosteamcore.repo;

import com.example.videosteamcore.entities.FileStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepo extends MongoRepository<FileStatus,String> {
     FileStatus findByFileName(String filename);
     List<FileStatus> findByFileNameOrderByProgress(String fileName);
}
