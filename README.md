## Архитектура ПО

**Оглавление:**

[UML диаграмма классов](#uml-диаграмма-классов)  
[Паттерн фабричный метод](#паттерн-фабричный-метод)  
[Объектно-ориентированные паттерны](#объектно-ориентированные-паттерны)  
[SOLID](#solid)  
[Связанность и сочетаемость](#связанность-и-сочетаемость)  
[Принципы архитектуры](#принципы-архитектуры)  
[Принципы связности](#принципы-связности)  
[Принципы сочетаемости компонентов](#принципы-сочетаемости-компонентов)  
[Паттерны доступа к данным](#паттерны-доступа-к-данным)  
[Критерии чистой архитектуры](#критерии-чистой-архитектуры)  
[KISS DRY YAGNI](#kiss-dry-yagni)  
[Архитектура прикладных приложений MVC MVP MVVM](#архитектура-прикладных-приложений-mvc-mvp-mvvm)  



## UML диаграмма классов

UML происходит от Unified Modeling Language, 
если по- русски, то — унифицированный язык моделирования.  

Видео разбор [UML Диаграмма Классов](https://www.youtube.com/watch?v=sVVJp5a41o4&t=11s)

[Полное руководство по диаграмме классов UML](https://www.cybermedian.com/ru/a-comprehensive-guide-to-uml-class-diagram/#Ogromnaa_kollekcia_BESPLATNYH_ucebnyh_resursov_pri_podderzke_VP_Community_Circle)

[UML для самых маленьких: диаграмма классов](https://habr.com/ru/articles/511798/)

Кратность или Множественность

0...n  
1...*  
0...*  

## Паттерн фабричный метод

Порождающий шаблон проектирования фабричный метод:

Который предоставляет дочерним классам интерфейс
для создания экземпляров некоторого класса.
В момент создания наследники могут определить какой класс создавать.
Иными словами данный шаблон делегирует создание
объектов наследником родительского класса.
Это позволяет использовать в коде программы не специфические классы
а манипулировать абстрактными объектами на более высоком уровне.

Достоинства фабричного метода:
позволяет сделать код создания объектов более
универсальным не привязываясь к конкретным
классам, а оперируя лишь общим интерфейсом.
Позволяет установить связь между
параллельными иерархиями классов.

Недостатком паттерна является
необходимость создавать наследника для
каждого нового типа.

<details> 
  <summary>Фабричный метод (Factory Method)</summary>
Это порождающий паттерн проектирования, который определяет общий
интерфейс для создания объектов в суперклассе, позволяя подклассам
изменять тип создаваемых объектов.
Метод фабрики считается креативным паттерном проектирования, то есть
связанным с созданием объектов. В паттерне «Фабрика» мы создаём объект,
не раскрывая логики создания клиенту, а клиент использует тот же общий
интерфейс для создания нового типа объекта.
Паттерн «Фабрика» вводит свободную связь между классами, что считается
наиболее важным принципом, который необходимо учитывать и применять
при проектировании архитектуры приложения. Свободная связь может быть
введена в архитектуру приложения путём программирования на основе
абстрактных сущностей, а не конкретных реализаций. Это делает нашу
архитектуру не только более гибкой, но и менее хрупкой.

Назначение
Определяет интерфейс для создания объекта, но оставляет подклассам
решение, какой класс инстанцировать. Фабричный метод позволяет классу
делегировать инстанцирование подклассам.

Проблема
Представим, что требуется создать программу управления грузовыми
перевозками. Изначально перевозки осуществляются на грузовых
автомобилях, поэтому весь код работает с объектами класса «Грузовик».
В какой-то момент программой заинтересовались морские перевозчики. Но
большая часть кода привязана к классу «Грузовик». Чтобы добавить в
программу классы морских судов, надо исправить большую часть кода.
Изменения будут требоваться каждый раз при добавлении нового вида
транспорта.
Таким образом, получится очень большой код, наполненный условными
операторами, определяющими тип транспорта.

Применимость  
Паттерн «Фабричный метод» стоит использовать:  
● когда заранее неизвестны типы и зависимости объектов, с которыми
работает код;  
● когда хотим дать возможность пользователям расширять части нашего
фреймворка или библиотеки;  
● когда требуется экономить системные ресурсы, повторно используя уже
созданные объекты, вместо порождения новых.  

Преимущества и недостатки

Преимущества
1. Избавляет класс от привязки
   к конкретным классам
   продуктов.
2. Выделяет код производства
   продуктов в одно место,
   упрощая поддержку кода.
3. Упрощает добавление новых
   продуктов в программу.
4. Реализует принцип
   открытости/закрытости.

Недостатки
5. Иногда приводит к созданию
   больших параллельных иерархий
   классов, так как для каждого
   класса продукта надо создать
   свой подкласс создателя.
</details>

Три причины почему нужно использовать этот паттерн.  

1. Объект определяется во время исполнения то-есть в runtime.  
Когда объект заранее не известен.

2. Паттерн выполняет принцип SOLID open close principle,
который говорит что классы должны быть открыты для расширения,
но закрыты для модификации.  
Возможность безопасно менять объекты. 

3. Повторное использование наработанного функционала.  

[Java Factory Method Фабричный Метод | Design Patterns](https://www.youtube.com/watch?v=X5G67aWO7CA&list=PLKP3l9fd3KUFbrccxZMI0z3CgRdBDCp-g)  
[Factory Method Pattern | В чем суть?](https://habr.com/ru/articles/556512/)  
[Factory Patterns - Simple Factory Pattern](https://www.codeproject.com/Articles/1131770/Factory-Patterns-Simple-Factory-Pattern)

## Объектно-ориентированные паттерны

[Паттерны проектирования программ на языке Java](https://www.youtube.com/playlist?list=PLKP3l9fd3KUFbrccxZMI0z3CgRdBDCp-g)  

## SOLID

SRP: Single Responsibility Principle. Принцип единственной ответственности  
OCP: Open-Closed Principle. Принцип открытости или закрытости  
LSP: Liskov Substitution Principle. Принцип подстановки Барбары Лисков  
ISP: Interface Segregation Principle. Принцип разделения интерфейсов  
DIP: Dependency Inversion Principle. Принцип инверсии зависимости  

SRP:  
Один класс-метод делает одно действие  
OCP:   
Класс открыт для расширений, но закрыт от модификаций  
LSP:  
Обратно совместимый и переносимый код  
ISP:   
Не надо делать интерфейсы с огромным количеством методов разных по ответственности  
DIP:  
Использовать интерфейсы что-бы не допустить циклических зависимостей между классами  

## Связанность и сочетаемость

>Низкая связанность и высокая сочетаемость являются целевыми
> аспектами хорошего проектирования программного обеспечения.
> 
>Низкая связанность означает, что компоненты или модули в 
> системе имеют минимальную зависимость друг от друга. 
> Каждый компонент должен иметь четко определенную ответственность 
> и не должен иметь излишних зависимостей от других компонентов. 
> Поддержание низкой связанности облегчает изменение и тестирование 
> компонентов, поскольку изменения в одном компоненте не влияют на другие 
> компоненты. Кроме того, низкая связанность способствует повторному 
> использованию компонентов в других частях системы или в других проектах.  
> 
>Высокая сочетаемость означает, что компоненты или модули в 
> системе могут быть легко переиспользованы или заменены без 
> влияния на остальную систему. Компоненты с высокой сочетаемостью 
> обеспечивают четко определенный интерфейс, который позволяет 
> другим компонентам взаимодействовать с ними. 
> Это делает систему более гибкой и масштабируемой, 
> поскольку компоненты могут быть комбинированы и заменены без
> необходимости изменения других компонентов.  
> 
>Для достижения низкой связанности и высокой сочетаемости, 
> рекомендуется следовать принципам SOLID 
> (Single Responsibility, Open/Closed, Liskov Substitution, 
> Interface Segregation, Dependency Inversion) 
> и использовать хорошо определенные интерфейсы и 
> абстракции для взаимодействия между компонентами. 
> Также полезно разделить систему на модули или слои 
> с четко определенными ответственностями и минимальными 
> зависимостями между ними.

#### Принципы архитектуры

Да, это тот самый SOLID, и более глубокие, связанные с ними принципы построения архитектуры

Эти базовые принципы применимы к любой парадигме программирования и любому виду ПО, т.к. по своей сути, они описывают правила поведения для логически завершенных объединений значений и функций, которые в ООП, например, являются классами

SRP - Single Responsibility Principle

Принцип единственной ответственности

OCP - Open-Close Principle

LSP - Liskov Substitution Principle

ISP - Interface Segregation Principle

DIP - Dependecy Inversion Principle

### Принципы связности

#### REP - Reuse/Release Equivivalence Pronciple

Принцип эквивалентности повторного использования и выпусков

Классы и модули, составляющие один общий логический компонент, должны принадлежать одной связанной группе. Обязательно должная быть общая тема/цель/функционал, объединяющие все элементы компонента

Аналогично для релизов компонента - все его составляющие должны входить в этот релиз. Т.е. нельзя выпустить библиотеку для стриминга аудио без поддержки сетевой части этого стриминга

Является включительным, т.к. говорит о  правиле объединении множества объектов в компонент

#### CCP - Common Closure Principle

Принцип согласованного изменения

Пересекается с Single Responsibility Principle в рамках одного компонента. Для изменения компонента должна быть всегда одна и только одна конкретная причина. Схож с REP и детальнее раскрывает связность - в рамках компонента должны объединяться классы, которые могут быть изменены по одной общей причине в одно время. В результате мы получаем лучшее деление на компоненты и меньшие трудозатраты по изменению/расширению функционала

Является включительным, т.к. говорит о  правиле объединении множества объектов в компонент

### CRP - Common Reuse Principle

Принцип совместного повторного использования

Определяет правило включения классов/модулей в один общий компонент по принципу - компонент может зависеть только от тех объектов, функционал которых он использует, не должно быть лишних зависимостей, в лучшем случае компонент должен зависеть только от объектов, функции которых используются полностью (или хотя бы относятся по своему смыслу исключительно к задачам компонента).

Нарушение принципа ведет к появлению лишних не используемых зависимостей (функций) в компоненте ведет к ситуации когда изменения в подключенной к компоненту зависимости ведут за собой изменения в самом компоненте, что необходимо исключать в правильной архитектуре

Является обобщенной версией принципа ISP, т.к. так же является исключительным, и стремиться к уменьшению компонентов

В итоге получается противоречие между принципами REP/CCP и CRP. Первые два включительные и стремятся к увеличению компонента через объединение его частей по правилам, а второй наоборот говорит об исключении лишних зависимостей. Отсюда получается, что одна из главных задач архитектора - поиск баланса между этими принципами, исходя из условий задачи

**Важно помнить:**

- **В начале разработки баланс обычно смещен в пользу CCP и дешевле пожертвовать повторным использование в угоду скорости и удобства разработки, по мере развития проекта уклон будет уже в пользу CRP т.к. все больше компонентов будут переиспользоваться и его необходимо соблюдать для большей гибкости в поддержке и расширении**
- **Баланс между соблюдением тех или иных принципов постоянно смещается, это нормально и за этим необходимо следить, т.к. удачное разбиение компонентов на первом этапе развития приложения, может быть неактуальным в дальнейшем и компоненты будут постоянно меняться с течением времени**

### Принципы сочетаемости компонентов

И снова важен баланс - принципы проектирования могут противоречить или ограничивать друг друга и то, в какую сторону какого принципа вести дизайн больше - зависит от задач, контекста и планов развития проекта

#### ADP - Acyclic Dependecies Princilple Принцип ацикличности зависимостей

Принцип ацикличности зависимостей - недопустимы циклы в графе зависимостей, самый простой пример - ошибка с циклической зависимостью при сборке графа Dagger 2

Ацикличный граф не только уменьшает количество вероятных ошибок, но и сокращает количество ненужных зависимостей позволяет пройти полный путь по графу зависимостей от начала и до конца. Т.е. мы всегда знаем и быстро определяем всю цепочку зависимостей, в которой присутствует класс/копонент/модель и т.д.

Такой граф зависимостей - Ациклически ориентированный (Directed Acyclic Graph)

Как создать/поддержать такой граф зависимостей или исправить цикл:

- Воспользоваться DIP и развернуть поток управления той зависимости, которая приводит к циклу, самое простое - закрыть за интерфейсом и делегировать реализацию в нужный компонент
- Создать новый компонент, от которого будут зависеть те компоненты, которые ранее создавали данную циклическую зависимость

#### SDP - Staple Dependecies Principle Принцип устойчивых зависимостей

Устойчивость в данном ключе можно расшифровать как сложность изменения компонента. Может показаться, что устойчивым должен быть объект с минимумом зависящих от него компонентов, но на самом деле все наоборот:

Чем больше больше объектов зависит от компонента, тем больше согласованных изменений в нем нужно произвести, т.е. повышает сложность его изменения, а значит и устойчивость

Отсюда и наоборот - чем меньше от компонента звисит, тем менее он устойчив и легче поддается изменениям

I = F-in / (F-in - F-out)

I -  устойчивость от 0 до 1 (где 0 - максимальная устойчивость)

F-in - количество объектов, зависящих от компонента

F-out - количество объектов, от которых зависит компонент

Для чего все это?

Для основы принципа SDP - устойчивость компонента должна быть больше устойчивости компонентов, от которых он зависит. Метрика устойчивость должна уменьшаться в направлении зависимости. От самых неустойчивых к самым стабильным.

Например компоненты Android SDK можно считать более устойчивыми по отношению к компонентам разрабатываемого приложения. Core модуль приложения так же более устойчив (в правильной реализации архитектуры), и от него зависят менее устойчивые модули, по типу сетевой части, которая использует его базовый инструментарий

api service → network tooling → core

Где core - самый устойчивый, а api service - самый неустойчивый

Отсюда выходит ограничение - устойчивые компоненты не должны содержать зависимостей от неустойчивых, то есть в core модуль не должен зависеть от конкретных моделей api service

#### SAP - Stable Abstractions Principle Принцип устойчивости абстракций

Абстрактность компонента должна быть пропорциональная его устойчивости

Устойчивый компонент, это может быть и хорошо, но как в такой ситуации сделать его достаточно гибким? Использовать абстракции, которые позволят сделать компонент более податливым к расширению функционала, что будет соответствовать принципу OCP SOLID

Наиболее поддающийся к расширению компонент будет содержать больше интерфейсов и абстрактных классов

Чаща весов:

Устойчивость против Абстрактности

**Снова дело в балансе**

- Чем более устойчивые и менее абстрактные компоненты, тем сложнее их расширить, это самые неповоротливые части системы. Но такие компоненты тоже имеют место быть - базовые классы SDK, базы данных, низкоуровневые инструменты с минимумом зависимостей, это меняется с очень небольшой вероятностью
- С другой стороны чем менее устойчивые и более абстрактные компоненты - тем меньше пользы они приносят и меньше используются в проекте, вплоть до того, что это могут быть просто забытые и неиспользуемые интерефейсы и классы

Выход так, что где-то по середине должен быть баланс Устойчивости и абстрактности, и он идет таким образом

Чем более абстрактный компонент - тем более он должен быть устойчивый, и наоборот - менее устойчивый - значит менее абстрактный, то есть более конкретный

Снова пример из структуры

api service → network tooling → core

Здесь в api service содержатся более конкретные модели данных, конкретные реализации сетевых интерфейсов, которые менее устойчивы, по сравнению с абстракциями этих интерфейсов в network tooling

**Интересная мысль из книги:**

**Цель формы/структуры архитектуры - упростить разработку, деплой и сопровождение системы, где главная стратегия упрощения заключается в том, чтобы и дальше можно было иметь больше вариантов и гибкости**

## Паттерны доступа к данным

Data Access Object (DAO)  
Row Data Gateway  
Active Record  
Table Data Gateway  
Data Mapper  
Repository (Репозиторий)  
Domain Model (Модель предметной области)  
Service Layer (Слой служб)  
Data Transfer Object (Объект передачи данных)  

## Критерии чистой архитектуры  

Роберт Мартин

![clean-architecture.jpg](lesson-6%2Fimg%2Fclean-architecture.jpg)

Независимость от фреймворков  
Независимость от базы данных  
Независимость от пользовательского интерфейса  
Независимость от любых внешних агентов  
Простота тестирования  

[Чистая архитектура](https://habr.com/ru/articles/269589/)  
[Экскурсия с гидом по кодовой базе чистой архитектуры](https://proandroiddev.com/a-guided-tour-inside-a-clean-architecture-code-base-48bb5cc9fc97)  

### Шестиугольная архитектура 
Или архитектура портов и адаптеров, является архитектурным шаблоном, 
используемым при разработке программного обеспечения. 
Она направлена на создание слабосвязанных компонентов приложений,
которые могут быть легко подключены к их программной среде с помощью портов и адаптеров. 
Это делает компоненты взаимозаменяемыми на любом уровне и облегчает автоматизацию тестирования.

[Пример шестигранной архитектуры](https://yandex.ru/images/search?from=tabbar&img_url=https%3A%2F%2Fmiro.medium.com%2Fv2%2Fresize%3Afit%3A4952%2F0*kS_Y9t9gpdjYssd1.png&lr=121823&pos=6&rpt=simage&text=hexagon%20architecture)  

Из таких шестигранников строятся микросервисы.

### Чистая архитектура

Тезисы о важности архитектуры в программном продукте:

* Хорошая архитектура позволяет минифицировать затраты на поддержку и улучшение программы в будущем.
* Если не продумать архитектуру на старте проекта, а заниматься только продуктовыми задачами, то вскоре стоимость этих задач сильно возрастёт. Возможно, что в один момент придётся перестать работать над функционалом и сесть за дорогостоящее переделывание архитектуры.
* Не стоит откладывать «на потом» архитектурные моменты. Вряд ли это время наступит, а плохие решения могут надолго закрепиться в проекте.
* С плохой архитектурой увеличение количества разработчиков не поможет масштабированию.

### Ценности программы

У программного обеспечения есть две ценности: структура и поведение.

Поведение — это то, как программа работает, какие требование бизнеса выполняет. Именно ради поведения бизнес нанимает разработчиков и платит им деньги.

Но кроме этого, у софта есть и другая ценность — структура. Структура — это возможность вносить изменения в программу.

Если программа работает правильно, но в неё нельзя вносить правки, она быстро придёт в негодность. Однако же, если программа работает неправильно, но в неё можно без проблем вносить правки, то исправить ошибку не составит большого труда.

Выбор между этими двумя ценностями — это всегда борьба. Борьба, в которой разработчику необходимо научиться доказывать пользу от рефакторинга и улучшения архитектуры.

> Что важнее — правильная работа системы или простота ее изменения? Если задать этот вопрос руководителю предприятия, он наверняка ответит, что важнее правильная работа. Разработчики часто соглашаются с этим мнением. Но оно ошибочно.

### Тесты

Тесты — не панацея. Наличие тестов не гарантирует, что программа работает правильно.

> Все, что дает тестирование после приложения достаточных усилий, — это уверенность, что программа действует достаточно правильно.

## Парадигмы программирования

Парадигмы программирования не добавляют нам новых возможностей, а что‑то запрещают, говорят о том, чего не стоит делать. Эти запреты позволяют строить более надёжные программы, которые легко адаптировать к новым требованиям.

### Структурное программирование

**Накладывает ограничение на прямую передачу управления.** СП ознаменовалось отказом от безусловных переходов (_go to_) в пользу условных операторов и циклов.

Методология структурного программирования появилась как следствие усложнения программного обеспечения — неструктурированная разработка порождала программы, которые было сложно поддерживать.

### ООП

ООП вовсе не про инкапсуляцию (ее можно организовать через заголовочные файлы в _C_, или через замыкания в _JavaScript_), не про про наследование и не про полиморфизм (обеспечить полиморфное поведение можно имея в распоряжении только функции), а про инверсию зависимостей. **ООП накладывает ограничение на косвенную передачу управления.**

### Функциональное программирование

Главный принцип функционального программирования — запрет за изменение значений. Программу, данные в которой не меняются, легче понимать. **Функциональное программирование накладывает ограничение на присваивание.** Кроме этого ФП предлагает _event sourcing_ — подход, когда хранится не состояния, а транзакции (переходы между состояниями).

### SOLID

Принципы SOLID определяют, как функции и структуры данных объединять в сущности, и как эти сущности взаимодействуют друг с другом.

Использование этих принципов позволяет повысить вероятность того, что программист создаст систему, которую будет легко поддерживать и расширять в течение долгого времени.

#### Single Responsibility Principle

Программисты часто неправильно понимают суть этого принципа и считают, что он про ситуацию, когда «каждый модуль отвечает за что-то одно». На самом же деле, этот принцип про то, что **только у одной группы заинтересованных лиц должна быть причина изменять модуль**.

Часто при нарушении принципа единственной ответственности в репозитории образовываются мердж-конфликты — это индикатор того, что в коде есть проблемы. Кроме этого, нарушение SRP чревато разрушением системы в тех местах, которые не имеют прямого отношения к непосредственно изменяемому компоненту.

Соблюдать принцип единственной ответственности помогает TDD, а также паттерны «Выделение класса» и «Фасад».

#### Open Closed Principle

**Программные сущности должна быть открыты для расширения и закрыты для изменения.**

«Открытость для расширения» означает, что поведение сущности может быть расширено путём создания новых типов сущностей.

«Закрытость для изменения» говорит о важности проектирования системы таким образом, чтобы при добавления нового функционала количество изменений в существующем коде стремилось к нулю.

#### Liskov Substitution Principle

Принцип заключается в том, что если B является подтипом типа A, то тогда все объекты типа A в программе могут быть безболезненно заменены объектами типа B. Иными словами, **код должен иметь возможность работать с любым подтипом, так будто это базовый тип**.

Классический пример нарушения принципа LSP — наследование класса `Square` от класса `Rectangle` (определяющим методы `setHeight` и `setWidth`). Квадрат, расширяющий класс прямоугольника, не получится использовать как прямоугольник из-за того, что стороны квадрата равны и не могут задаваться отдельно.

#### Interface Segregation Principle

Принцип разделения интерфейсов говорит о том, что **программные сущности не должны зависеть от методов, которые они не используют.**

На практике это значит, что нужно разбивать «толстые» интерфейсы на более мелкие, лучше удовлетворяющие потребностям конкретных сущностей.

#### Dependency Inversion Principle

**Лучше не зависеть от деталей, потому что они нестабильны.** Абстракции меняются реже конкретных реализаций.

Применяя этот принцип, одни модули можно легко заменять другими посредством замены модуля зависимости. В такой ситуации перемены в низкоуровневом модуле не повлияют на высокоуровневый.

Разумеется, полностью соблюсти этот принцип для всех не получится — некоторые сущности будут знать о конкретной реализации. Лучше, чтобы о реализациях знало минимальное число модулей.

### Компоненты

Компоненты — это единицы развёртывания. Они представляют наименьшие сущности, которые можно развертывать в составе системы.

* Классы и модули компонента должны выпускаться вместе и иметь общую цель использования, применяться для решения конкретной задачи.
* В один компонент должны включаться классы, которые меняются по одним причинам и в одно время (смотри Open Closed Principle).
* Нельзя допускать зацикленности в графе зависимостей компонента. Если в зависимостях есть цикл, его можно разорвать с помощью принципа инверсии зависимостей.

### Принцип стабильных зависимостей

Зависимости должны быть направлены в сторону устойчивости. Некоторые компоненты должны быть более изменяемыми, но важно, чтобы менее стабильные компоненты всегда зависели от более стабильных.

**Нестабильность = Кол‑во выходов / (Кол‑во входов + Кол‑во выходов)**

### Принцип стабильности абстракций

Компонент должен быть настолько же абстрактным, насколько он стабилен.

**Абстрактность = Кол‑во абстрактных классов и интерфейсов в компоненте / Общее количество классов в компоненте**

### Границы

Границы должны отделять сущности, которые имеют значение для бизнес‑логики, 
от тех, которые не имеют. Например, 
бизнес‑логика не должна зависеть ни от схемы БД, ни от языка запросов.

### Чистая архитектура

* _Сущности_ инкапсулируют критичные бизнес‑правила.
* _Юзкейсы_ содержат специфические для приложения правила.
* _Адаптеры интерфейсов_ конвертируют данные из формата, удобного для юзкейсов, в формат удобный для внешних слоёв.

### Признаки чистой архитектуры

* **Не зависит от фреймворков**. Грамотная архитектура у проекта — та, при которой выбор фреймворка становится настолько неважным, что это решение можно откладывать до самого последнего момента.

* **Не зависит от пользовательского интерфейса, базы данных и каких-либо внешних агентов**.
  Бизнес‑логике не важно, какую мы используем базу данных, будем ли мы доставлять данные через веб или иначе, она не зависит от устройства, на котором будет работать система и т.д.

* **Легко тестируется**. Если тесты сильно связаны с компонентами, то небольшое изменение может уронить сотни тестов.

### KISS DRY YAGNI
[5 принципов читаемого кода](https://habr.com/ru/companies/itelma/articles/546372/)

#### KISS (Keep It Simple, Stupid) - Принцип "Делай проще, глупец":
KISS - это принцип простоты в проектировании и разработке программного обеспечения. 
Он предполагает, что проще всегда лучше, и сложность должна минимизироваться везде, 
где это возможно. Важно создавать простые и понятные решения, которые легко понять 
и поддерживать. Приложения и системы должны быть построены так, чтобы их архитектура 
и код были интуитивно понятны для разработчиков и легко изменяемы при необходимости.

#### DRY (Don't Repeat Yourself) - Принцип "Не повторяйся":
DRY - это принцип, который подразумевает, что каждая часть знания в системе должна
иметь одну, однозначную и авторитетную представительство в коде. Не следует повторять
один и тот же код в разных частях программы. Если у вас есть повторяющийся код, это может
привести к проблемам с поддержкой, так как изменения нужно вносить во множество мест, 
что увеличивает вероятность ошибок и затрудняет понимание системы.

#### YAGNI (You Ain't Gonna Need It) - Принцип "Вам это не понадобится":
YAGNI предполагает, что не следует добавлять функциональность в программу, 
пока это не требуется текущими требованиями. Не следует предполагать будущие 
потребности и вносить код для функциональности, которая может никогда не понадобиться. 
Это помогает избежать излишней сложности и ненужных зависимостей в коде.

### Архитектура прикладных приложений MVC MVP MVVM

#### Признаки хорошей архитектуры

- Гибкость и сбалансированное распределение обязанностей между сущностями
с жёсткими ролями.  
- Соблюдение принципа открытости-закрытости.  
- Возможность повторного использования.  
- Простота тестирования.  
- Независимость UX/UI.  
- Независимость от какого-либо внешнего сервиса или фреймворков.  
- Простота использования и низкая стоимость обслуживания.  

### Вариации семейства MV*-паттернов

- MVC  
- MVP  
- MVPM  
- MVVM  
- MVPVM  
- MVI  
- VIPER  
- RIBS  

[Использование шаблона посредника в MVVM / WPF](https://www.technical-recipes.com/2016/using-the-mediator-pattern-in-mvvm-wpf/)  