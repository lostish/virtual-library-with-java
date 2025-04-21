package sh.losti.app.models;

import sh.losti.app.enums.EBookmarkType;

import java.util.Date;

public class ProfileBookmark {
    private int profileId;
    private int bookmarkId;
    private EBookmarkType bookmarkType;
    private int bookPostId;
    private Date createdAt;
    private Date updatedAt;

    public ProfileBookmark(
            int profileId,
            int bookmarkId,
            EBookmarkType bookmarkType,
            int bookPostId,
            Date createdAt,
            Date updatedAt
    ) {
        this.profileId = profileId;
        this.bookmarkId = bookmarkId;
        this.bookmarkType = bookmarkType;
        this.bookPostId = bookPostId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
