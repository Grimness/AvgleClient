package com.batch.avgleclient.home

import android.view.View
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.batch.avgleclient.ItemVideoBindingModel_
import com.batch.avgleclient.model.AvVideo


class VideoListController(private val callback: ClickListener) : PagedListEpoxyController<AvVideo.Response.Video>() {

    interface ClickListener {
        fun itemClickListener(item: AvVideo.Response.Video)
    }

    override fun buildItemModel(
        currentPosition: Int,
        item: AvVideo.Response.Video?
    ): EpoxyModel<*> {
        return ItemVideoBindingModel_().apply {
            id(currentPosition)
            item?.let {
                video(it)
            }
            itemClickListener(View.OnClickListener { callback.itemClickListener(video()) })
        }
    }

//    override fun addModels(models: List<EpoxyModel<*>>) {
//        super.addModels(models)
//        itemLoading {
//            id("loading")
//        }
//    }

}