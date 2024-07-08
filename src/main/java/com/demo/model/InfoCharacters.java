package com.demo.model;

import java.util.Optional;

public class InfoCharacters {
    private Long count;
    private Long pages;
    private String next;
    private Optional<Boolean> prev;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Optional<Boolean> getPrev() {
        return prev;
    }

    public void setPrev(Optional<Boolean> prev) {
        this.prev = prev;
    }
}
