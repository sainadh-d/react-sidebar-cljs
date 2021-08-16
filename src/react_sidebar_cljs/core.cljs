(ns react-sidebar-cljs.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as rf]
   [react-sidebar-cljs.events :as events]
   [react-sidebar-cljs.views :as views]
   ["@blueprintjs/core" :refer [FocusStyleManager]]))



(defn ^:dev/after-load mount-root []
  (rf/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/root] root-el)))

(defn init []
  (.onlyShowFocusOnTabs FocusStyleManager)
  (rf/dispatch-sync [::events/initialize-db])
  (mount-root))
