;Natalia Alonso
;COMP333 Spring 14
;March 11, 2014
;Project 3

#lang racket
( define fsm1 
  ( lambda ( x  state)
     ( cond
       ( ( =  state  0)
         (cond
           ( (null? x)  #f)
           ( (= (car x)  0) (fsm1  (cdr x)  0))
           ( (= (car x)  1) (fsm1  (cdr x)  1))
           ( else  #f))) 
       ( ( =  state  1) 
         (cond
           ( (null? x)  #f)
           ( (= (car x)  0) (fsm1  (cdr x)  1))
           ( (= (car x)  1) (fsm1  (cdr x)  2))
           ( else  #f))) 
       ( (=  state  2)
         (cond
           ( (null? x)  #t)
           ( (= (car x)  0) (fsm1  (cdr x)  2))
           ( (= (car x)  1) #f)
           ( else  #f))) 
       ))) 

(define fsmFP
  (lambda (x state)
    ( cond
       ((= state 0)
       (cond
         ((null? x) #f)
         ((char-numeric? (car x)) (fsmFP (cdr x) 2))          
         ((equal? (car x) #\+) (fsmFP (cdr x) 1))
         ((equal? (car x) #\-) (fsmFP (cdr x) 1))
         ( else  #f)))
       ((= state 1)
       (cond
         ((null? x) #f)
         ((char-numeric? (car x)) (fsmFP (cdr x) 2)) 
         ( else  #f)))       
       ((= state 2)
       (cond
         ((null? x) #f)
         ((equal? (car x) #\.) (fsmFP (cdr x) 3))
         ( else  #f))) 
       ((= state 3)
       (cond
         ((null? x) #f)
         ((char-numeric? (car x)) (fsmFP (cdr x) 4)) 
         ( else  #f)))
       ((= state 4)
       (cond
         ((null? x) #t)
         ((char-numeric? (car x)) (fsmFP (cdr x) 4)) 
         ((equal? (car x) #\e) (fsmFP (cdr x) 5))
         ( else  #f)))
       ((= state 5)
       (cond
         ((null? x) #f)
         ((equal? (car x) #\+) (fsmFP (cdr x) 6))
         ((equal? (car x) #\-) (fsmFP (cdr x) 6))
         ( else  #f)))
       ((= state 6)
       (cond
         ((null? x) #f)
         ((char-numeric? (car x)) (fsmFP (cdr x) 7)) 
         ( else  #f)))
       ((= state 7)
       (cond
         ((null? x) #t)
         ((char-numeric? (car x)) (fsmFP (cdr x) 8)) 
         ( else  #f)))
       ((= state 8)
       (cond
         ((null? x) #t)
         ((char-numeric? (car x)) (fsmFP (cdr x) 9)) 
         ( else  #f)))
       ((= state 9)
       (cond
         ((null? x) #t)
         ( else  #f)))
       )))

(define floatingPt?
  (lambda (s)
    (fsmFP (string->list s) 0)))