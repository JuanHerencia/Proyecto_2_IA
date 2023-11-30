;; Definicion del problema
;; los objetos,
;; el estado inicial,
;; la meta a alcanzar.
(define (problem p01)
  (:domain logistics)

  ;; Objectos
  ;; Ser�n 5 objetos
  ;; Un cami�n      : truck
  ;; Un avi�n       : airplane
  ;; Dos aeropuertos: cdg, lhr
  ;; Dos lugares    : north, south
  ;; Dos ciudades   : london, paris
  ;; Dos paquetes   : p1, p2
  (:objects plane - airplane
    truck - truck
    cdg lhr - airport
    south north - location
    paris london - city
    p1 p2 - package
  )

  ;; Estado inicial
  ;; El estado inicial es un conjunto de predicados fundamentales. Un predicado 
  ;; se basa si todas las variables est�n enlazadas a objetos. Los predicados de 
  ;; base en el estado inicial representan hechos verdaderos en este estado. 
  ;; Cualquier hecho que no est� representado en un state es false.
  (:init (in-city cdg paris)
    (in-city lhr london)
    (in-city north paris)
    (in-city south paris)
    (at plane lhr)
    (at truck cdg)
    (at p1 lhr)
    (at p2 lhr)
  )

  ;; Descripci�n del objetivo
  ;; El objetivo es tener at(p1, north) y at(p2, south) en el estado final 
  ;; (sin importar el valor de verdad del otro predicados)
  (:goal (and (at p1 north)
    (at p2 south))
  )
)