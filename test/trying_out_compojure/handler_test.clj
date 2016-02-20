(ns trying-out-compojure.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [trying-out-compojure.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404))))

  (testing "name route"
    (let [response (app (mock/request :get "/greet?name=Kristo"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello Kristo!")))))