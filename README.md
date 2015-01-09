Software Evolution Monitor Tool
=========

The goal of the project is the development of a tool to be facilitate the assesment of [Lehm's laws](http://en.wikipedia.org/wiki/Lehman's_laws_of_software_evolution) on the evolution of software systems.

It is a project made for the undergraduate class of Software Engineering of the University of Ioannina - Greece during the fall semester of the academic year 2014 - 2015.

For trying out the tool you can use [documents/sample input/AmazonMechTurk.txt](https://github.com/sfotiadis/SEMonitor/blob/master/documents/sampe%20input/AmazonMechTurk.txt) as a sample input.

## Implementation notes

The implementation followed closely on the design. The changes that were introduced were mainly Java related implementation details. The design principles remained mainly intact. I was happy about that fact because it could be received as a sign of good design. Any comments on that matter are more than welcome.

For the creation of the graphs the [JFreeChart](http://www.jfree.org/jfreechart/) library was used.

The final gui looks like that:

![main gui](https://raw.githubusercontent.com/sfotiadis/SEMonitor/master/documents/gui%20final/final_gui_1.png)
![law gui](https://raw.githubusercontent.com/sfotiadis/SEMonitor/master/documents/gui%20final/final_gui_2.png)

The created report looks something like that:
![report ](https://raw.githubusercontent.com/sfotiadis/SEMonitor/master/documents/sample%20output/report-snapshot.png)

The report template was derived from [bricemason's previous work](https://github.com/bricemason/am-i-sencha-touch-ready).

## Design

Both the design documents and the source code are included in the repo. Unfortunately the documentation is in greek but the diagrams that hold the essence of the desing can be understood fine.

The requested tool was quite lightweight so the design was base on the [Model-View-Presenter pattern](http://en.wikipedia.org/wiki/Model–view–presenter).

The quality of the design is measured by common metrics as [Coupling Between Object Classes (CBO)](http://www.arisa.se/compendium/node105.html) and [Response for a Class (RFC)](http://www.arisa.se/compendium/node98.html).

The documenation includes the following:
* Requirements Definition (given by the tutor)
* Requirements Specification
* Architectural & Technical Design Document

Also there are included the packet, class and sequence diagrams that where designe with [Eclipse's](http://eclipse.org) plugin [Papyrus](http://eclipse.org/papyrus/).

## Prototype

### Main Menu

![main gui](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/gui%20prototype/prototype-main.png)

### Lehman's law evaluation

![laws gui](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/gui%20prototype/prototype-laws.png)

## Package Diagram
![packages diagram](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/diagrams/Packages.png)

## Class Diagrams

### Models
![models diagram 1](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/diagrams/Model1.png)
![models diagram 2](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/diagrams/Model2.png)

### Views
![views diagram](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/diagrams/Views.png)

### Presenter
![presenter diagram](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/diagrams/Presenter.png)

### IO

![io diagram](https://github.com/kabamarules/SEMonitor/blob/master/documents/diagrams/IO.png)

## Sequence Diagrams

### New release history
![sequence diagram 1](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/diagrams/sd-2.2.1.png)

### Select release history
![sequence diagram 2](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/diagrams/sd-2.2.2.png)

### Return to main menu
![sequence diagram 3](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/diagrams/sd-2.2.3.png)

### Lehmans' Laws evaluation
![sequence diagram 4](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/diagrams/sd-2.2.4-11.png)

### Create report
![sequence diagram 4](https://raw.githubusercontent.com/kabamarules/SEMonitor/master/documents/diagrams/sd-2.2.12.png)
