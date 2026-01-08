package dna.issue_service.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Issue {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long projectId;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private Long assigneeId;

    @Column(nullable = false)
    private Long reporterId;

    @ManyToOne
    @JoinColumn(name = "issue_group_id")
    private IssueGroup issueGroup;
    @Enumerated
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
