(ns gerenciadorDeDataShow.datashow)

; Fernando
; datashow -> definição de datashow (id, horario)
(defrecord Datashow [id horario])

; Otavio
; listaDeDatashows -> definição de lista de datashows (datashows)



;; Agente para gerenciar o vetor de datashows
(def ListaDeDatashows (agent []))

;; Função para adicionar um datashow ao vetor
(defn adicionar-datashow [datashow]
  (await ListaDeDatashows)
  (conj (deref ListaDeDatashows) datashow))

;; Função para atualizar o status de um datashow
(defn atualizar-horario [id horario]
  (await ListaDeDatashows)
  (mapv (fn [datashow]
          (if (= (:id datashow) id)
            (assoc datashow :horario horario)
            datashow))
        (deref ListaDeDatashows)))

;; Função para remover um datashow pelo ID
(defn remover-datashow [id]
  (filterv #(not= (:id %) id) (deref ListaDeDatashows)))

(defn puxar-datashow [id]
  (await ListaDeDatashows)
  (first (filter #(= (:id %) id) (deref ListaDeDatashows))))