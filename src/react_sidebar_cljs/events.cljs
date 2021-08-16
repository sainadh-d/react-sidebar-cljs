(ns react-sidebar-cljs.events
  (:require
   [re-frame.core :as rf]
   [react-sidebar-cljs.db :as db]))
   

(rf/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-event-db
 ::toggle-sidebar
 (fn [db _]
   (update db :sidebar-open? not)))
