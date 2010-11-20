(ns speclj.report.verbose
  (:use
    [speclj.reporting :only (failure-source tally-time default-reporter)]
    [speclj.exec :only (pass? fail?)]
    [speclj.report.console :only (print-summary)]
    [speclj.util :only (endl)])
  (:import
    [speclj.reporting Reporter]
    [speclj SpecFailure]))

(deftype VerboseReporter []
  Reporter
  (report-description [this description]
    (println)
    (println (.name description)))
  (report-pass [this result]
    (println (str "- " (.name (.characteristic result))))(flush))
  (report-fail [this result]
    (println (str "- " (.name (.characteristic result)) " (FAILED)"))(flush))
  (report-runs [this results]
    (print-summary results)))

(defn new-verbose-reporter []
  (VerboseReporter.))