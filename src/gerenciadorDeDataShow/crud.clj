(ns gerenciadorDeDataShow.crud
  (:require [gerenciadorDeDataShow.datashow :as datashow]))


; Uaná
; criar (id) -> cria um novo datashow com horario "indefinido"
; Vou assumir que tem um agente para a lista chamado ListaDeDatashows
(defn criar [id]
  (let [ds (datashow/puxar-datashow id)]
    (if (ds == nil)
      (let [ds (datashow/datashow. id "indefinido")]
        (send-off datashow/ListaDeDatashows (datashow/adicionar-datashow ds)))
      (println "Datashow já existe"))))

; Alvaro
; alocar (id, horario) -> aloca datashow(id) a um horario
(defn alocar [id horario]
  (let [ds (datashow/puxar-datashow id)]
    (if (nil? ds)
      (println "Datashow não encontrado")
      (send-off datashow/ListaDeDatashows
                (fn [lista]
                  (if (contains? lista id)
                    (assoc lista id (datashow/atualizar-horario (get lista id) horario))
                    (do (println "Datashow não encontrado na lista") lista)))))))

; Malu
; desalocar (id) -> desaloca datashow(id)
(defn desalocar [id]
  (let [ds (datashow/puxar-datashow id)]
    (if (nil? ds)
      (println "Datashow não encontrado")
      (send-off datashow/ListaDeDatashows
                #(mapv (fn [datashow]
                         (if (= (:id datashow) id)
                           (assoc datashow :horario "indefinido")
                           datashow))
                       %)))))


; Malu
; realocar (id, horario) -> realoca datashow(id) para um novo horario
(defn realocar [id novo-horario]
  (let [ds (datashow/puxar-datashow id)]
    (if (nil? ds)
      (println "Datashow não encontrado")
      (send-off datashow/ListaDeDatashows
                #(mapv (fn [datashow]
                         (if (= (:id datashow) id)
                           (assoc datashow :horario novo-horario)
                           datashow))
                       %)))))


; Laura
; deletar (id) -> deleta datashow(id)
(defn deletar [id]
  (send-off datashow/ListaDeDatashows (datashow/remover-datashow id)))
; Uaná
; listar () -> lista todos os datashows
(defn listar []
  (await datashow/ListaDeDatashows)
  (deref datashow/ListaDeDatashows))
