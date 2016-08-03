package snapdealModule

import geb.Module

/**
 * Created by abhilashk on 8/3/2016.
 */
class HomePageModule extends Module{
    static content={
        menuLink {menu->$(".catText", text:menu)}
        submenuLink{submenu->$(".headingText", text:submenu)}


    }
}
