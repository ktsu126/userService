package com.mentor.common.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CollectionResponse<T> {

    private List<T> content;
    private boolean hasNext;
    private Long totalCount; // todo 현재는 미적용 코드들이 있어서 nullable, 모든 API에 적용된 이후에는 not null

    public CollectionResponse(List<T> content, boolean hasNext) {
        this.content = content;
        this.hasNext = hasNext;
        this.totalCount = null;
    }

    public CollectionResponse(List<T> content, boolean hasNext, Long totalCount) {
        this.content = content;
        this.hasNext = hasNext;
        this.totalCount = totalCount;
    }
}
