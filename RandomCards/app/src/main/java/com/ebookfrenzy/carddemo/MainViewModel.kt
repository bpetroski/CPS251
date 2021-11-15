package com.ebookfrenzy.carddemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    companion object {
        private var liveTitles: MutableLiveData<Array<String>> = MutableLiveData()
        private var liveDetails: MutableLiveData<Array<String>> = MutableLiveData()
        private var liveImages: MutableLiveData<IntArray> = MutableLiveData()
        var titles = arrayOf("")
        var details = arrayOf("")
        var images = intArrayOf()

        fun initTitlesArray(titles: Array<String>){
            titles.shuffle()
            this.titles = titles
            liveTitles.setValue(titles)
        }
        fun initDetailsArray(details: Array<String>){
            details.shuffle()
            this.details = details
            liveDetails.setValue(details)
        }
        fun initImagesArray(images: IntArray){
            images.shuffle()
            this.images = images
            liveImages.setValue(images)
        }
        fun getTitle(i: Int): String {
            var title = "Title"
            title = liveTitles.getValue()?.get(i).toString()
            return title
        }
        fun getDetail(i: Int) : String {
            var detail = "detail"
            detail = liveDetails.getValue()?.get(i).toString()
            return detail
        }
        fun getImage(i: Int) : Int {
            var image = R.drawable.abc_vector_test
            image = (liveImages.value?.get(i) ?: Int) as Int
            return image
        }
    }
}