(ns gerenciadorDeDataShow.core)

; integrantes: Uaná, Fernando, Alvaro, Malu, Laura, Guilherme, Otavio

; Guilherme
; main -> receber input, fazer requests pro crud e imprimir responses (assincrono) 

; Fernando 
; imprimirMenu -> imprime o menu

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
    "1" (crud/listar-datashows) ;; Request para listar datashows

    "2" (do
          (print "ID do Datashow: ") (flush)
          (let [id (Integer/parseInt (read-line))]
            (print "Horário da alocação do Datashow: ") (flush)
            (let [horario (read-line)]
              (crud/alocar-datashow id horario)))) ;; Request para alocar

    "3" (do
          (print "ID do Datashow: ") (flush)
          (let [id (Integer/parseInt (read-line))]
            (print "Horário da desalocação do Datashow: ") (flush)
            (let [horario (read-line)]
              (crud/desalocar-datashow id horario)))) ;; Request para desalocar

    "4" (do
          (print "ID do novo Datashow: ") (flush)
          (let [id (Integer/parseInt (read-line))]
              (crud/criar-datashow id horario)))) ;; Request para criar

    "5" (do
          (print "ID do Datashow para deletar: ") (flush)
          (let [id (Integer/parseInt (read-line))]
            (crud/deletar-datashow id))) ;; Request para deletar

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
