;; logistics.pddl
;; Definición del archivo dominio
(define (domain logistics)
  ;; Requisitos
  ;; strips : las acciones solo usarán precondiciones positivas (predicados que deben ser verdaderos en el estado actual para desencadenar acciones) y efectos deterministas (efectos que necesariamente siguen a la activación de la acción). No se permite nada más.
  ;; typing : usaremos "tipos" como en la programación OO para representar conjuntos de objetos en el mundo.
  (:requirements :strips :typing)

  ;; Tipos
  ;; city, place, physobj son considerados como objetos (object),
  ;; Packages y vehicles son objetos físicos (physobj),
  ;; Trucks y airplanes son vehicles,
  ;; Airports y locations son places
  (:types city place physobj - object
    package vehicle - physobj
    truck airplane - vehicle
    airport location - place
  )

  ;; Predicados
  ;; in-city(loc, city) - true si un lugar loc está en la ciudad ciudad
  ;; at(obj, loc) - true si un objeto físico obj está en el lugar loc
  ;; in(pkg, veh) - true si el paquete A está en un vehículo veh
  (:predicates (in-city ?loc - place ?city - city)
    (at ?obj - physobj ?loc - place)
    (in ?pkg - package ?veh - vehicle)
  )

  ;; Operadores
  ;; El dominio tiene 5 operadores: load-truck, load-airplaine, unload-truck, unload-airplane, drive-truck y fly-aiplane

  ;; Operador Load Truck
  ;; Por ejemplo, en el ámbito de la logística, se puede cargar un camión... Y para 
  ;; cargar un camión, necesitamos un paquete pkg y un camión truck en una ubicación 
  ;; place. Para cargar pkg en truck, estos dos objetos deben estar en el mismo lugar 
  ;; loc. Los efectos de Cargando pkg en truck es que in(pkg, truck) se convierte en 
  ;; true y at(pkg, loc) se convierte en falso. Cualquier otro hecho en el estado actual 
  ;; no cambia
  (:action load-truck
    :parameters (?pkg - package ?truck - truck ?loc - place)
    :precondition (and (at ?truck ?loc) (at ?pkg ?loc))
    :effect (and (not (at ?pkg ?loc)) (in ?pkg ?truck))
  )

  ;; Operador Load Airplane
  ;; Acción/Operador
  ;; Descripción  : Carga un paquete pkg en un avión airplane en el lugar loc,
  ;; Precondition : at(pkg, loc) y at(airplane, loc) deben ser verdaderos,
  ;; Efecto       : in(pkg, airplane) se convierte a true y at(airplane, loc) se convierte a false.
  (:action load-airplane
    :parameters (?pkg - package ?airplane - airplane ?loc - place)
    :precondition (and (at ?pkg ?loc) (at ?airplane ?loc))
    :effect (and (not (at ?pkg ?loc)) (in ?pkg ?airplane))
  )
  
  ;; Operador de descarga de camión - Unload Truck
  ;; Acción/Operador  
  ;; Descripción  : Descargar un paquete pkg en un camión truck en el lugar loc,
  ;; Precondición : in(pkg, truck) and at(truc, loc) serán true,
  ;; Efecto       : at(pkg, loc) viene a ser true y in(pkg, truck) viene ser false. 
  (:action unload-truck
    :parameters (?pkg - package ?truck - truck ?loc - place)
    :precondition (and (at ?truck ?loc) (in ?pkg ?truck))
    :effect (and (not (in ?pkg ?truck)) (at ?pkg ?loc))
  )

  ;; Operador Descargar Avión - Unload Airplane
  ;; Acción/Operador  
  ;; Descripción  : descargar un paquete pkg en un avión airplane en el lugar loc,
  ;; Precondición : in(pkg, airplane) y at(airplane, loc) deben ser true,
  ;; Efecto       : at(pkg, loc) será true y in(pkg, airplane) será false.
  (:action unload-airplane
    :parameters (?pkg - package ?airplane - airplane ?loc - place)
    :precondition (and (in ?pkg ?airplane) (at ?airplane ?loc))
    :effect (and (not (in ?pkg ?airplane)) (at ?pkg ?loc))
  )

  ;; Operador volar Avión, Fly-airplane
  ;; Acción/Operador  
  ;; Descripción  : Volar airplane pkg desde un lugar loc hasta un lugar loc-to,
  ;; Precondición : at(pkg, loc-from) será true,
  ;; Efecto       : at(pkg, loc-to) viene a ser true y at(p, loc-from) viene a ser false.
  (:action fly-airplane
    :parameters (?airplane - airplane ?loc-from - airport ?loc-to - airport)
    :precondition (at ?airplane ?loc-from)
    :effect (and (not (at ?airplane ?loc-from)) (at ?airplane ?loc-to))
  )

  ;; Operador conducir camión, Drive-truck
  ;; Acción/Operador  
  ;; Descripción  : Conducir camión truck desde el lugar loc-from hacia el lugar loc-to,
  ;; Precondición : at(truck, loc-from) será true,
  ;; Efecto       : at(truck, loc-to) será true y at(truck, loc-from) será false.
  (:action drive-truck
    :parameters (?truck - truck ?loc-from - place ?loc-to - place ?city - city)
    :precondition (and (at ?truck ?loc-from) (in-city ?loc-from ?city) (in-city ?loc-to ?city))
    :effect (and (not (at ?truck ?loc-from)) (at ?truck ?loc-to))
  )
)
