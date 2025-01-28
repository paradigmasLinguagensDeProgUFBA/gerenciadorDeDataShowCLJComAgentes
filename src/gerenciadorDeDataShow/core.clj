(ns gerenciadorDeDataShow.core)

; integrantes: Uaná, Fernando, Alvaro, Malu, Laura, Guilherme, Otavio

; Guilherme
; main -> receber input, fazer requests pro crud e imprimir responses (assincrono) 

; Fernando 
; imprimirMenu -> imprime o menu
(defn imprimirMenu []
  (println "Menu:")
  (println "1. Criar Datashows")
  (println "2. Alocar Datashow")
  (println "3. Desalocar Alocação")
  (println "4. Realocar Alocação")
  (println "5. Deletar Datashow")
  (println "6. Consultar Alocação")
  (println "7. Listar Datashows")
  (println "8. Imprimir Resultado")
  (println "9. Sair"))
