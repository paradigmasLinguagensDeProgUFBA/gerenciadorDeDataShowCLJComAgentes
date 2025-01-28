(ns gerenciadorDeDataShow.core
  (:require [gerenciadorDeDataShow.crud :as crud])

; integrantes: Uaná, Fernando, Alvaro, Malu, Laura, Guilherme, Otavio

; Guilherme
; main -> receber input, fazer requests pro crud e imprimir responses (assincrono) 

; Fernando 
; imprimirMenu -> imprime o menu
(defn receber-input []
  (println "========== MENU ==========")
  (println "1. Listar Datashows")
  (println "2. Alocar Datashow")
  (println "3. Desalocar Datashow")
  (println "4. Criar Datashow")
  (println "5. Deletar Datashow")
  (println "6. Realocar Datashow")
  (println "0. Sair")
  (print "Escolha uma opção: ")
  (flush)
  (read-line))


; Alvaro
; imprimirResultado ([]datashows) -> imprime o resultado de uma operacao



;;;;;;;;;;;;;;;;;;;;
; AREA DO MENU
;;;;;;;;;;;;;;;;;;;;


(defn receber-input []
  (menu)
  (print "Escolha uma opção: ") (flush)
  (read-line))

  (defn executar-opcao [opcao]
  (case opcao
    "1" (imprimir-resultado (crud/listar)) ;; Request para listar datashows

    "2" (do
          (print "ID do Datashow: ") (flush)
          (let [id (Integer/parseInt (read-line))]
            (print "Horário da alocação do Datashow: ") (flush)
            (let [horario (read-line)]
              (crud/alocar id horario)))) ;; Request para alocar

    "3" (do
          (print "ID do Datashow: ") (flush)
          (let [id (Integer/parseInt (read-line))]
            (print "Horário da desalocação do Datashow: ") (flush)
            (let [horario (read-line)]
              (crud/desalocar id horario)))) ;; Request para desalocar

    "4" (do
          (print "ID do novo Datashow: ") (flush)
          (let [id (Integer/parseInt (read-line))]
              (crud/criar id)))) ;; Request para criar

    "5" (do
          (print "ID do Datashow para deletar: ") (flush)
          (let [id (Integer/parseInt (read-line))]
            (crud/deletar id))) ;; Request para deletar

    "6" (do
          (print "ID do Datashow a ser realocado: ") (flush)
          (let [id (Integer/parseInt (read-line))]
            (print "Horário da realocação do Datashow: ") (flush)
            (let [horario (read-line)]
              (crud/realocar-datashow id horario)))) ;; Request para realocar       

    "0" (System/exit 0) ;; Sair
    (println "Opção inválida.")))


;;;;;;;;;;;;;;;;;;;;
; AREA DO IMPRIMIR-RESPOSTA
;;;;;;;;;;;;;;;;;;;;


(defn -main []
  (loop []
    (let [opcao (receber-input)] 
      (executar-opcao opcao)     
      (imprimir-resposta opcao) 
      (recur))))                
