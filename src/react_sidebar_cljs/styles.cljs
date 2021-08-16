(ns react-sidebar-cljs.styles)

(def sidebar-closed-width 55)
(def sidebar-open-width 250)

(def styles
  {:sidebar {:height "100%"
             :width sidebar-closed-width
             :position "fixed"
             :top 0
             :left 0
             :background-color "#30404d"
             :overflow-x "hidden"
             :transition "all 0.5s"}

   :sidebar-header {:align-items "center"
                    :border-bottom "1px solid #515c64"
                    :display "flex"
                    :height 48
                    :justify-content "space-between"
                    :letter-spacing 1
                    :padding "0 12px"}
   
   :sidebar-menu-item {:height 40 
                       :padding 10}

   :main-content {:padding-left sidebar-closed-width
                  :transition "padding-left 0.5s"}})