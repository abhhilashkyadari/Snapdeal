package snapdealModule

import geb.Module

/**
 * Created by abhilashk on 8/3/2016.
 */
class SubMenuModule extends Module{
    static content={
        viewAll{$("a.color-white")[0]}
        priceFrom{$(".input-filter",name:"fromVal")}
        priceUpTo{$(".input-filter",name:"toVal")}
        search{$(".price-go-arrow>i")}
        expandCustomerRatingSection{$(".filter-type-name.lfloat", text:"Customer Rating")}
        customertRatingRadioButton{$(".filters-list.sdRadio>label", for: "avgRating-4.0")}
        productsList{
            return $(".product-desc-rating.title-section-expand").allElements()
        }
        productTitle{$(".pdp-e-i-head")}
        ratingLink{$(".showRatingTooltip.reviewCacheUpdate")}
        ratingValue{$(".ratetxt>span")}

    }
}
