#### Логи

```powerShell

PS D:\3MobileDevelop\2Четверть\9АрхитектураПО\Software-architecture\lesson-9\Java\JsonDemo> Invoke-WebRequest -Uri http://localhost:8080/books -Method GET


StatusCode        : 200
StatusDescription : OK
Content           : {91, 93}
RawContent        : HTTP/1.1 200 OK
                    Content-Length: 2
                    Date: Fri, 18 Aug 2023 06:14:40 GMT

                    []                                                                                                                                                              Headers           : {[Content-Length, 2], [Date, Fri, 18 Aug 2023 06:14:40 GMT]}                                                                                                    RawContentLength  : 2                                                                                                                                                                                                                                                                                                                                                   


PS D:\3MobileDevelop\2Четверть\9АрхитектураПО\Software-architecture\lesson-9\Java\JsonDemo> Invoke-WebRequest -Uri http://localhost:8080/books -Method POST                         
                                                                          

StatusCode        : 201
StatusDescription : Created
Content           : {66, 111, 111, 107...}
RawContent        : HTTP/1.1 201 Created
                    Content-Length: 66
                    Date: Fri, 18 Aug 2023 06:14:59 GMT

                    Book added: Book{id=1, title='Book1', author='Author1', year=2021}                                                                                              Headers           : {[Content-Length, 66], [Date, Fri, 18 Aug 2023 06:14:59 GMT]}                                                                                                   RawContentLength  : 66                                                                                                                                                                                                                                                                                                                                                  


PS D:\3MobileDevelop\2Четверть\9АрхитектураПО\Software-architecture\lesson-9\Java\JsonDemo> Invoke-WebRequest -Uri http://localhost:8080/books -Method POST


StatusCode        : 201
StatusDescription : Created
Content           : {66, 111, 111, 107...}
RawContent        : HTTP/1.1 201 Created
                    Content-Length: 66
                    Date: Fri, 18 Aug 2023 06:15:00 GMT

                    Book added: Book{id=2, title='Book2', author='Author2', year=2021}                                                                                              Headers           : {[Content-Length, 66], [Date, Fri, 18 Aug 2023 06:15:00 GMT]}                                                                                                   RawContentLength  : 66                                                                                                                                                                                                                                                                                                                                                  


PS D:\3MobileDevelop\2Четверть\9АрхитектураПО\Software-architecture\lesson-9\Java\JsonDemo> Invoke-WebRequest -Uri http://localhost:8080/books -Method POST


StatusCode        : 201
StatusDescription : Created
Content           : {66, 111, 111, 107...}
RawContent        : HTTP/1.1 201 Created
                    Content-Length: 66
                    Date: Fri, 18 Aug 2023 06:15:01 GMT

                    Book added: Book{id=3, title='Book3', author='Author3', year=2021}                                                                                              Headers           : {[Content-Length, 66], [Date, Fri, 18 Aug 2023 06:15:01 GMT]}                                                                                                   RawContentLength  : 66                                                                                                                                                                                                                                                                                                                                                  


PS D:\3MobileDevelop\2Четверть\9АрхитектураПО\Software-architecture\lesson-9\Java\JsonDemo> Invoke-WebRequest -Uri http://localhost:8080/books -Method POST


StatusCode        : 201
StatusDescription : Created
Content           : {66, 111, 111, 107...}
RawContent        : HTTP/1.1 201 Created
                    Content-Length: 66
                    Date: Fri, 18 Aug 2023 06:15:02 GMT

                    Book added: Book{id=4, title='Book4', author='Author4', year=2021}
Headers           : {[Content-Length, 66], [Date, Fri, 18 Aug 2023 06:15:02 GMT]}
RawContentLength  : 66
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
PS D:\3MobileDevelop\2Четверть\9АрхитектураПО\Software-architecture\lesson-9\Java\JsonDemo> Invoke-RestMethod -Uri "http://localhost:8080/books/1" -Method Put -ContentType "application/json" -Body '{"title": "Boookk", "author": "Autoooot", "year": 2022}'
Book updated: Book{id=1, title='Boookk', author='Autoooot', year=2022}
PS D:\3MobileDevelop\2Четверть\9АрхитектураПО\Software-architecture\lesson-9\Java\JsonDemo> Invoke-WebRequest -Uri http://localhost:8080/books -Method GET                          
                                                                          

StatusCode        : 200
StatusDescription : OK
Content           : {91, 66, 111, 111...}
RawContent        : HTTP/1.1 200 OK
                    Content-Length: 226
                    Date: Fri, 18 Aug 2023 06:15:18 GMT

                    [Book{id=1, title='Boookk', author='Autoooot', year=2022}, Book{id=2, title='Book2', author='Author2', year=2021}, Book{id=...                                  Headers           : {[Content-Length, 226], [Date, Fri, 18 Aug 2023 06:15:18 GMT]}                                                                                                  RawContentLength  : 226                                                                                                                                                                                                                                                                                                                                                 


PS D:\3MobileDevelop\2Четверть\9АрхитектураПО\Software-architecture\lesson-9\Java\JsonDemo> Invoke-WebRequest -Uri http://localhost:8080/books/3 -Method DELETE                     
                                                                          

StatusCode        : 200
StatusDescription : OK
Content           : {66, 111, 111, 107...}
RawContent        : HTTP/1.1 200 OK
                    Content-Length: 23
                    Date: Fri, 18 Aug 2023 06:15:32 GMT

                    Book with ID 3 removed.                                                                                                                                         Headers           : {[Content-Length, 23], [Date, Fri, 18 Aug 2023 06:15:32 GMT]}                                                                                                   RawContentLength  : 23                                                                                                                                                                                                                                                                                                                                                  


PS D:\3MobileDevelop\2Четверть\9АрхитектураПО\Software-architecture\lesson-9\Java\JsonDemo> Invoke-WebRequest -Uri http://localhost:8080/books -Method GET                          
                                                                          

StatusCode        : 200
StatusDescription : OK
Content           : {91, 66, 111, 111...}
RawContent        : HTTP/1.1 200 OK
                    Content-Length: 170
                    Date: Fri, 18 Aug 2023 06:15:39 GMT

                    [Book{id=1, title='Boookk', author='Autoooot', year=2022}, Book{id=2, title='Book2', author='Author2', year=2021}, Book{id=...
Headers           : {[Content-Length, 170], [Date, Fri, 18 Aug 2023 06:15:39 GMT]}
RawContentLength  : 170



PS D:\3MobileDevelop\2Четверть\9АрхитектураПО\Software-architecture\lesson-9\Java\JsonDemo> 

```

