(ns react-sidebar-cljs.views
  (:require
   [re-frame.core :as rf]
   [react-sidebar-cljs.subs :as subs]
   [react-sidebar-cljs.events :as events]
   [react-sidebar-cljs.styles :refer [styles sidebar-open-width]]
   ["@blueprintjs/core" :refer [Classes Menu MenuItem Button Card Elevation]]))
   
(defn sidebar [open?]
  (let [sidebar-styles (:sidebar styles)
        modified-sidebar-styles (if open? (assoc sidebar-styles :width sidebar-open-width) sidebar-styles)]
    [:div {:class (.-DARK Classes) :style modified-sidebar-styles}
     [:div {:class "sidebar-header" :style (:sidebar-header styles)}
      (when open? [:div {:class "sidebar-logo"} "TITLE"])
      [:> Button {:icon (if open? "menu-closed" "menu-open") :minimal true :onClick #(rf/dispatch [::events/toggle-sidebar])}]]
     [:> Menu {:large true}
       [:> MenuItem {:icon "home" :text (when open? "Home") :style (:sidebar-menu-item styles)}]
       [:> MenuItem {:icon "settings" :text (when open? "Settings") :style (:sidebar-menu-item styles)}]
       [:> MenuItem {:icon "badge" :text (when open? "Badge") :style (:sidebar-menu-item styles)}]]]))

(defn main-panel [style]
  [:div {:style style}
    [:> Card {:interactive true :elevation (.-TWO Elevation)}
      [:h2 [:a {:href "#"} "React Sidebar using Clojurescript"]]
      [:p "Libraries used: Reagent, Reframe, Blueprintjs (for UI)"]]])
      

(defn root []
  (let [sidebar-open? @(rf/subscribe [::subs/sidebar-open?])
        main-content-styles (:main-content styles)]
    [:div
     [sidebar sidebar-open?]
     [main-panel 
      (if sidebar-open? 
        (assoc main-content-styles :padding-left sidebar-open-width)
        ;; else
        main-content-styles)]]))
     
 