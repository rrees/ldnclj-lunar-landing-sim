(ns lunar-landing.core-test
  (:use clojure.test
        lunar-landing.core)
  (:require [lunar-landing.core :as lander]))

(deftest lander-should-generate-course-corrections
	(testing "Lander did not respond"
		(is (not (nil? (lander/adjust {}))))))

(deftest land-at-rest-remains-at-rest
  (testing "Lander moved from rest"
    (is (= 0 (:thrust (lander/adjust {:height 0 :velocity 0}))))))