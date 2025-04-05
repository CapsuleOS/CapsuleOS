package com.CapsuleOS.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "capsules")
public class Capsule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String capsuleName;
    private String description;

    private Boolean isAlwaysAccessible;
    private LocalDateTime unlockTime;

    private String capsuleType; // IMAGE, VIDEO, TEXT, APP, BTC, NFT, etc.

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;


    @ManyToOne
    @JoinColumn(name = "parent_capsule_id")
    private Capsule parentCapsule;

    @OneToMany(mappedBy = "parentCapsule", cascade = CascadeType.ALL)
    private List<Capsule> nestedCapsules = new ArrayList<>();

    @OneToMany(mappedBy = "capsule", cascade = CascadeType.ALL)
    private List<CapsuleVersion> versions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCapsuleName() {
        return capsuleName;
    }

    public void setCapsuleName(String capsuleName) {
        this.capsuleName = capsuleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAlwaysAccessible() {
        return isAlwaysAccessible;
    }

    public void setAlwaysAccessible(Boolean alwaysAccessible) {
        isAlwaysAccessible = alwaysAccessible;
    }

    public LocalDateTime getUnlockTime() {
        return unlockTime;
    }

    public void setUnlockTime(LocalDateTime unlockTime) {
        this.unlockTime = unlockTime;
    }

    public String getCapsuleType() {
        return capsuleType;
    }

    public void setCapsuleType(String capsuleType) {
        this.capsuleType = capsuleType;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Capsule getParentCapsule() {
        return parentCapsule;
    }

    public void setParentCapsule(Capsule parentCapsule) {
        this.parentCapsule = parentCapsule;
    }

    public List<Capsule> getNestedCapsules() {
        return nestedCapsules;
    }

    public void setNestedCapsules(List<Capsule> nestedCapsules) {
        this.nestedCapsules = nestedCapsules;
    }

    public List<CapsuleVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<CapsuleVersion> versions) {
        this.versions = versions;
    }
}
