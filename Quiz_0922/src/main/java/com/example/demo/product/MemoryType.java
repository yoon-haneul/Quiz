package com.example.demo.product;


import lombok.Getter;

@Getter
public enum MemoryType {
    CHILDHOOD("어린시절", "🧸"),
    FRIENDSHIP("우정", "👫"),
    LOVE("사랑", "💕"),
    ADVENTURE("모험", "🗺️"),
    FOOD("음식", "🍰"),
    TOY("장난감", "🎮"),
    EXPERIMENT("실험", "🧪");

    private final String displayName;
    private final String icon;

    MemoryType(String displayName, String icon) {
        this.displayName = displayName;
        this.icon = icon;
    }
}
