;; Counting Sundays
;; ================
;; You are given the following information, but you may prefer to do some research for yourself.
;; 1 Jan 1900 was a Monday.
;; Thirty days has September
;; April, June and November.
;; All the rest have thirty-one
;; Saving February alone
;; Which has twenty-eight, rain or shine.
;; And on leap years, twenty-nine.
;; A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
;; How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000) ?
;; ================

(let 
    [
        start-date      "01.01.1901"
        end-date        "31.12.2000"
        date-formater   (java.text.SimpleDateFormat. "dd.MM.yyyy")
     
        start           (.parse date-formater start-date)
        end             (.parse date-formater end-date)
     
        start-calendar  (java.util.Calendar/getInstance)
        end-calendar    (java.util.Calendar/getInstance)
     
        count           (atom 0)
    ]

    (.setTime start-calendar start)
    (.setTime end-calendar end)
    
    (loop []
        (when (.before start-calendar end-calendar)
            (when   (and 
                            (= (.get start-calendar java.util.Calendar/DAY_OF_MONTH) 1) 
                            (= (.get start-calendar java.util.Calendar/DAY_OF_WEEK) java.util.Calendar/SUNDAY)
                    )
                (swap! count inc)
            )

            (.add start-calendar java.util.Calendar/DAY_OF_MONTH 1)

            (recur)            
        )
    )
  
    @count
)