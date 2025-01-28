(ns gerenciadorDeDataShow.tabelaDeDatashows)

; Fernando
; datashow -> definição de datashow (id, horario)

; Otavio
; listaDeDatashows -> definição de lista de datashows (datashows)



;; Função para criar um datashow
(defn criar-datashow [id horario status]
  {:id id
   :horario horario
   :status status})

;; Agente para gerenciar o vetor de datashows
(def ListaDeDatashows (agent []))

;; Função para adicionar um datashow ao vetor
(defn adicionar-datashow [vetor datashow]
  (conj vetor datashow))

;; Função para atualizar o status de um datashow
(defn atualizar-status [vetor id novo-status]
  (mapv (fn [datashow]
          (if (= (:id datashow) id)
            (assoc datashow :status novo-status)
            datashow))
        vetor))

;; Função para remover um datashow pelo ID
(defn remover-datashow [vetor id]
  (filterv #(not= (:id %) id) vetor))
