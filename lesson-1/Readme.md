### UML Диаграмма классов

<details> 
  <summary>Кейс 1</summary>
На основе Диаграмы классов ModelElements

![UMLModelElements.jpg](img%2FUMLModelElements.jpg)

разработать классы:   

Model Store   
PoligonalModel (Texture, Poligon)  
Flash  
Camera  
Scene
</details>

<details> 
  <summary>Кейс 2</summary>
Ознакомиться с документацией в свободном формате, 
которая может пригодиться Вам для дальнейшей работы:

- ГОСТ Р ИСО/МЭК 12207-2010 Информационная технология (ИТ). 
Системная и программная инженерия. 
Процессы жизненного цикла программных средств.
- ISO/IEC/IEEE 29148:2018 Systems and software engineering — 
Life cycle processes — Requirements engineering
- Стандарты ЕСКД — единая система конструкторской документации ГОСТ 2.001-2013 ЕСКД. Общие положения
- Стандарты АСУ ГОСТ 34 — автоматизированные системы управления
- Стандарты ЕСПД ГОСТ 19 — единая система программной документации
</details>

---

Решение 1

#### Отношения между классами

Реализация  

Реализация относится к отношениям реализации между 
классом и абстрактным классом или интерфейсом в Java 
и является наиболее распространенной взаимосвязью между 
классом и интерфейсом.

Model Store реализует интерфейс IModelChanger  

![Realization.jpg](img%2FRealization.jpg)

Ассоциация и Агрегация

0...n

![AssociationAndAggregation.jpg](img%2FAssociationAndAggregation.jpg)

Композиция

1...*

![Composition.jpg](img%2FComposition.jpg)

Агрегация

0...*

1...*

![Aggregation.jpg](img%2FAggregation.jpg)