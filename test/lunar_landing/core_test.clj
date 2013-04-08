(ns lunar-landing.core-test
  (:use clojure.test
        lunar-landing.core)
  (:require [lunar-landing.core :as lander]))

(deftest lander-should-generate-course-corrections
	(testing "Lander did not respond"
		(is (not (nil? (lander/adjust {}))))))

(deftest land-at-rest-remains-at-rest
  (testing "Do not thrust when lander is on the ground"
    (is (= 0 (:thrust (lander/adjust {:height 0 :velocity 0}))))))

(def maximum-landing-velocity 1.0)

(deftest lander-lands-from-200m
  (testing "It does not break"
    (let [state (lander/fall-from-height 200)]
      (is (= 0 (:height state)))
      (is (< maximum-landing-velocity (:velocity state))))))
