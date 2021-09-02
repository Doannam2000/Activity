package dd.wan.activityfragnav.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Stock(var name:String,var location:String,var time:String,var rate:String,var percent:String):Parcelable {
}