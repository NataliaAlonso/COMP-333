#lang racket
(define range (lambda(a b c)(- (max a b c) (min a b c))))
(define g (lambda(x) (cond ((= x 1) "one") ((= x 2) "two") (else "not one or two"))))
(define fib (lambda(n) (cond ((= n 0) 1) ((= n 1) 1) (else (+ (fib (- n 1)) (fib (- n 2)))))))


