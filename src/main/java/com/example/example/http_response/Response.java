package com.example.example.http_response;

import com.example.example.controller.model.movie.MovieDetailWeb;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.http.codec.ServerSentEvent;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@JsonPropertyOrder({ "totalRecords", "pagination", "data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Object data;

    private long totalRecords;

    @JsonProperty("PaginationData")
    private Map<String, Object> pagination;

    public Response(Object data) {
        this.data = data;
    }

    public Response(Object data, long totalRecords) {
        this.data = data;
        this.totalRecords = totalRecords;
    }

    public void paginate(int page, int pageSize, String url) {
        this.pagination = new HashMap<>();
        this.pagination.put("page", page);
        this.pagination.put("page size", pageSize);
        int totalPages = (int) (Math.ceil((double) totalRecords / pageSize));
        this.pagination.put("total pages", totalPages);
        if(page > 1 && totalPages > 1)
            this.pagination.put("previous", url + "/movies?page=" + (page - 1));
        if(page < totalPages)
            this.pagination.put("next", url + "/movies?page=" + (page + 1));
    }
}
