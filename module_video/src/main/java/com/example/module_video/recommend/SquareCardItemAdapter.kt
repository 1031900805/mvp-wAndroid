package com.example.module_video.recommend

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.common_base.util.format
import com.example.common_base.widget.GlideRoundTransform
import com.example.module_video.R
import com.example.module_video.data.OpenRecBean

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/16
 *  description :
 */
class SquareCardItemAdapter(
    layoutResId: Int,
    list: MutableList<OpenRecBean.DataBeanXX.ItemListBean>
) :
    BaseQuickAdapter<OpenRecBean.DataBeanXX.ItemListBean, BaseViewHolder>(layoutResId, list) {

    override fun convert(holder: BaseViewHolder, item: OpenRecBean.DataBeanXX.ItemListBean) {

        holder.setText(R.id.tv_title, item.data.header.title)
        holder.setText(
            R.id.tv_description,
            item.data.content.data.author.name + " / #" +
                    item.data.content.data.category
        )

        holder.setText(R.id.tv_video_time, format(item.data.content.data.duration))

        Glide.with(holder.itemView)
            .load(item.data.header.icon)
            .placeholder(R.drawable.img_def)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(holder.getView(R.id.iv_author))

        Glide.with(holder.itemView)
            .load(item.data.content.data.cover.detail)
            .transform(GlideRoundTransform(context))
            .placeholder(R.drawable.img_def)
            .into(holder.getView(R.id.iv_video_cover))
    }
}