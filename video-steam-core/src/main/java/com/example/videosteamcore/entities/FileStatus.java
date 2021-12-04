package com.example.videosteamcore.entities;

import org.springframework.data.annotation.Id;
import lombok.Data;

import java.io.Serializable;

@Data
public class FileStatus implements Serializable {

    @Id
    private String id;

    private String fileName;

    private int progress;

    public FileStatus(String fileName, int progress) {
        this.fileName = fileName;
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "FileStatus{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", progress=" + progress +
                '}';
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
