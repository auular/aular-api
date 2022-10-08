package teste.aular.domain.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.Instant;
import java.util.UUID;

@Entity
public class Partner {
    @Id
    @GeneratedValue
    private int id;

    private UUID uuid;

    private String name;
    private String email;
    private String password;
    private String document_id;
    private boolean fidelity;
    private String phone_number;

    @CreationTimestamp
    private Instant created_at;

    @UpdateTimestamp
    private Instant updated_at;

    private Instant deleted_at;

    public Partner(
            UUID uuid,
            String name,
            String email,
            String password,
            String document_id,
            boolean fidelity,
            String phone_number
    ) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
        this.document_id = document_id;
        this.fidelity = fidelity;
        this.phone_number = phone_number;
        this.created_at = Instant.now();
        this.updated_at = Instant.now();
        this.deleted_at = null;
    }

    protected Partner() {
        this.uuid = UUID.randomUUID();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public boolean isFidelity() {
        return fidelity;
    }

    public void setFidelity(boolean fidelity) {
        this.fidelity = fidelity;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public Instant getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }

    public Instant getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Instant deleted_at) {
        this.deleted_at = deleted_at;
    }
}
