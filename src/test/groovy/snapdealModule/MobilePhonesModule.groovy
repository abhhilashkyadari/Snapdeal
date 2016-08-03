package snapdealModule

import geb.Module

/**
 * Created by abhilashk on 8/3/2016.
 */
class MobilePhonesModule extends Module{
    static content={
        priceRage{range->$(".img-banner.dp-widget-link", title:range)}
    }
}
