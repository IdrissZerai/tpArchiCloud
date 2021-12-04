package com.example.videosteamcore.repo;

import com.example.videosteamcore.entities.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public  class MessageService{

    @Autowired
    MessageRepo messagerepo;

    @Cacheable("FileStatus")
    public FileStatus save(FileStatus fileStatus){
        return messagerepo.save(fileStatus);
    }

    @Cacheable("FileStatus")
    public FileStatus getFileStatus(String filename){
        FileStatus fs1 = messagerepo.findByFileName(filename);
        return fs1;
    }

    @CachePut(value = "FileStatus", key = "#filename")
    public FileStatus updateFileStatus(String filename,int progress){
        FileStatus fs = messagerepo.findByFileName(filename);
        fs.setProgress(progress);
        return messagerepo.save(fs);
    }

}
