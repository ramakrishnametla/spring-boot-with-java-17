package com.mrk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Modern Spring Boot 3.x: Configuration properties with records (Java 24)
@Component
@ConfigurationProperties("server")
public class ServerProperties {

    private String email;
    private List<Cluster> cluster = new ArrayList<>();

    // Java 24: Modern record for nested configuration
    public record Cluster(String ip, String path) {
        // Compact constructor for validation
        public Cluster {
            if (ip != null) {
                ip = ip.trim();
            }
            if (path != null) {
                path = path.trim();
            }
        }
        
        // Java 24: String templates for modern toString
        @Override
        public String toString() {
            return STR."Cluster{ip='\{ip}', path='\{path}'}";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Cluster> getCluster() {
        return cluster;
    }

    public void setCluster(List<Cluster> cluster) {
        this.cluster = cluster;
    }

    // Java 24: String templates for modern toString
    @Override
    public String toString() {
        return STR."ServerProperties{email='\{email}', cluster=\{cluster}}";
    }
}
