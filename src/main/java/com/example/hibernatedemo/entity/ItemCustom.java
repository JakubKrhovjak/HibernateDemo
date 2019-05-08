package com.example.hibernatedemo.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Jakub krhovják on 10/22/17.
 */
//@Entity
//@Audited(targetAuditMode = NOT_AUDITED)
public class ItemCustom {

    @EmbeddedId
    private ItemCustomId id;

    @ManyToOne
    @MapsId("itemId")
    private Item item;

    @ManyToOne
    @MapsId("customId")
    private Custom custom;

    private ItemCustom() {
    }

    public ItemCustom(Item item, Custom custom) {
        this.item = item;
        this.custom = custom;
        this.id = new ItemCustomId(item.getItemId(), custom.getCustomId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCustom that = (ItemCustom) o;
        return Objects.equals(item, that.item) &&
                Objects.equals(custom, that.custom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, custom);
    }

    @Embeddable
    public static class ItemCustomId implements Serializable {
        private Long itemId;
        private Long customId;

        public ItemCustomId() {
        }

        public ItemCustomId(Long itemId, Long customId) {
            this.itemId = itemId;
            this.customId = customId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ItemCustomId that = (ItemCustomId) o;
            return Objects.equals(itemId, that.itemId) &&
                    Objects.equals(customId, that.customId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(itemId, customId);
        }
    }
}
