(ns react-sidebar-cljs.subs
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 ::sidebar-open?
 (fn [db]
   (:sidebar-open? db)))
