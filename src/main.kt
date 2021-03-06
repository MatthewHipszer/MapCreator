import java.awt.Color
import java.awt.Dimension
import java.awt.EventQueue
import java.awt.event.ActionEvent
import java.awt.event.ItemEvent
import java.awt.event.KeyEvent
import javax.swing.*
import javax.swing.SwingConstants.LEADING
import kotlin.system.exitProcess


class Main(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        val colorArray = arrayOf<Color>(
            Color.black, Color.blue, Color.cyan,
            Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta,
            Color.orange, Color.pink, Color.red, Color.white, Color.yellow
        )

        val labels = colorArray.map {
            JLabel("", null, LEADING).apply {
                minimumSize = Dimension(90, 40)
                background = it
                isOpaque = true
            }
        }

        val closeButton = JButton("Close").apply {
            minimumSize = Dimension(90, 40)
            isOpaque = true
        }
        closeButton.addActionListener { exitProcess(0) }

        val checkBox = JCheckBox("Show title", true)

        checkBox.addItemListener { e ->
            val sel: Int = e.stateChange
            if (sel == ItemEvent.SELECTED) {
                setTitle("JCheckBox")
            } else {
                setTitle("")
            }
        }

        val imageLabel = JLabel(ImageIcon("src/resources/images.png"))

        createLayout(labels, closeButton, checkBox, imageLabel)

        setTitle(title)

        createMenuBar()


        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(1000, 500)
        setLocationRelativeTo(null)
    }

    private fun createLayout(labels: List<JLabel>, vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true
        gl.autoCreateGaps = true

        gl.setHorizontalGroup(
            gl.createParallelGroup()
                .addGroup(
                    gl.createSequentialGroup()
                        .addComponent(arg[2])
                )
                .addGroup(
                    gl.createSequentialGroup()
                        .addComponent(labels[0])
                        .addComponent(labels[1])
                        .addComponent(labels[2])
                        .addComponent(labels[3])
                )
                .addGroup(
                    gl.createSequentialGroup()
                        .addComponent(labels[4])
                        .addComponent(labels[5])
                        .addComponent(arg[0])
                        .addComponent(labels[6])
                        .addComponent(labels[7])
                        .addComponent(labels[8])
                        .addComponent(labels[9])
                        .addComponent(labels[11])
                        .addComponent(labels[10])
                )
                .addComponent(labels[12])
                .addComponent(arg[1])
        )

        gl.setVerticalGroup(
            gl.createSequentialGroup()
                .addGroup(
                    gl.createParallelGroup()
                        .addComponent(arg[2])
                )
                .addGroup(
                    gl.createParallelGroup()
                        .addComponent(labels[0])
                        .addComponent(labels[1])
                        .addComponent(labels[2])
                        .addComponent(labels[3])
                )
                .addGroup(
                    gl.createParallelGroup()
                        .addComponent(labels[4])
                        .addComponent(labels[5])
                        .addComponent(arg[0])
                        .addComponent(labels[6])
                        .addComponent(labels[7])
                        .addComponent(labels[8])
                        .addComponent(labels[9])
                        .addComponent(labels[11])
                        .addComponent(labels[10])
                )
                .addComponent(labels[12])
                .addComponent(arg[1])
        )

        pack()
    }


    private fun createMenuBar() {

        val menuBar = JMenuBar()
        val icon = ImageIcon("src/resources/exit.png")

        val file = JMenu("File")
        file.mnemonic = KeyEvent.VK_F

        val eMenuItem = JMenuItem("Exit", icon)
        eMenuItem.mnemonic = KeyEvent.VK_E
        eMenuItem.toolTipText = "Exit application"
        eMenuItem.addActionListener { _: ActionEvent -> exitProcess(0) }

        file.add(eMenuItem)
        menuBar.add(file)

        jMenuBar = menuBar
    }
}

private fun createAndShowGUI() {

    val frame = Main("Simple")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}