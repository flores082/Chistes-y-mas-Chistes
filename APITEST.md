APITEST

Usamos Humorapi para llamar chistes, los cuales se mostraran en una lista en la pantalla

Nuestras pruebas usan keys en forma de "apiKey" para darnos una key que no este en limite aún (3 keys para un total de 30 llamadas).
Los resultados son hechos por un Debug log a traves del código.

Aviso: La consultas de API dependen de la internet y conexión estable. Si la consulta se demora mucho en procesar, es posible que sea por conexión de internet.

- Prueba 1:

Consulta al API: GET https://api.humorapi.com/jokes/random?api-key=$apiKey

Resultado (Exito):
Raw API response: {"id":29817,"joke":"My first job was working in an orange juice factory, but I got canned: couldn't concentrate."}

- Prueba 2:

Consulta al API: GET https://api.humorapi.com/jokes/random?api-key=$apiKey&exclude-tags=nsfw,dark

Raw API response: {"id":38273,"joke":"Once a programmer drowned in the sea. Many Marines where at that time on the beach, but the programmer was shouting \"F1 F1\" and nobody understood it."}

- Prueba 3: 

Consulta al API: GET https://api.humorapi.com/jokes/random?api-key=$apiKey&exclude-tags=nsfw,dark

Raw API response: {"id":48241,"joke":"Teacher: I'd like a room, please. Hotel Receptionist: Single, Sir? \nTeacher: Yes, but I am engaged."}
