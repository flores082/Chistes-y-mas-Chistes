APITEST

Usamos Humorapi para llamar chistes, los cuales se mostraran en una lista en la pantalla

Prueba:
GET https://api.humorapi.com/jokes/random?api-key=$apiKey

$apikey=c8c056772f514c588bd3d690d7352d54,0483ff33f77a4c77a7dbb9d1c407ca32,e5978b4ec9864dc4a11cf79e47696e63
se utilisan uno de los dos.

Exito

Raw API response: {"id":29817,"joke":"My first job was working in an orange juice factory, but I got canned: couldn't concentrate."}
2023-12-16 21:44:25.012 31039-31039 ApiRequestTask

Exito. Este demuestra ser mas largo

Raw API response: {"id":7399,"joke":"Punishment\nRabbi Bloom caught two of his rabbinical\nstudents gambling and drinking on Sabbath. Next day, Rabbi Bloom called\nthem into his office and asked them what was going on. They immediately\nconfessed to having given in to weakness and agreed that they deserved\nsome form of punishment for their sin.\nRabbi Bloom thought a lot about this and\nthen came up with the answer. He bought two bags of dried peas from the\ndelicatessen and told them, \"Put these in your shoes and walk on them for\na week to remind yourselves how hard life can be when you turn away from\nGod.\"\nA few days later, the two students met\neach other in the street. One had a pronounced limp and had dark circles\nunder his eyes. He looked very tired and weary. On the other hand, the\nother was the same as he had been before.\n\"Hey,\" said the first. \"How is it that\nyou are walking so easily? Why didn`t you do as the Rabbi asked and put\nthe peas in your shoes?\"\n\"I did,\" said the other. \"But I boiled\nthem first.\""}
2023-12-16 22:20:51.040 31780-31780 ApiRequestTask          com..._Sepulveda.chistesymaschistes  D  ID: 7399, Joke: Punishment
                                                                                                    Rabbi Bloom caught two of his rabbinical
                                                                                                    students gambling and drinking on Sabbath. Next day, Rabbi Bloom called
                                                                                                    them into his office and asked them what was going on. They immediately
                                                                                                    confessed to having given in to weakness and agreed that they deserved
                                                                                                    some form of punishment for their sin.
                                                                                                    Rabbi Bloom thought a lot about this and
                                                                                                    then came up with the answer. He bought two bags of dried peas from the
                                                                                                    delicatessen and told them, "Put these in your shoes and walk on them for
                                                                                                    a week to remind yourselves how hard life can be when you turn away from
                                                                                                    God."
                                                                                                    A few days later, the two students met
                                                                                                    each other in the street. One had a pronounced limp and had dark circles
                                                                                                    under his eyes. He looked very tired and weary. On the other hand, the
                                                                                                    other was the same as he had been before.
                                                                                                    "Hey," said the first. "How is it that
                                                                                                    you are walking so easily? Why didn`t you do as the Rabbi asked and put
                                                                                                    the peas in your shoes?"
                                                                                                    "I did," said the other. "But I boiled
                                                                                                    them first."
                                                                                                    

Abiso:

dependiedno del internet y la conección. si por algun error de coneccion al internet la API no podra generar el chiste. 
como demostracion un compañero pudo generar la coneccion y otro no pudo generarla por problemas de conección
