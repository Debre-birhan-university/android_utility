# 🛠️ Android Graphics & Multimedia Lab Guide

**Technologies:** Kotlin, Jetpack Compose, Media3 (ExoPlayer), CameraX
**Prerequisites:** Basic knowledge of Jetpack Compose state management and UI layouts.

---

## Part 1:  Canvas

*In this section, we will build a progressive graphics application. We will start with an empty canvas, draw shapes, style them, animate them, and finally make them respond to touch.*

### Lab 1.1.1: Introduction to Canvas & Basic Shapes
Use the `Canvas` composable and DrawScope functions to draw a circle

```kotlin
@Composable
fun GraphicsScreen() {

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {

        // Drawing happens here

        drawCircle(
            color = Color.Red
        )
    }
}

```
### Lab 1.1.2: DRAWING BASIC SHAPES: 
Notice ... you need to adjust some part of the code.
```kotlin
@Composable
fun ShapesScreen() {
    // Modifier.fillMaxSize() gives us the entire screen as our drawing board
    Canvas(modifier = Modifier.fillMaxSize()) {

       // 1. Draw a Circle at the exact center of the screen
       drawCircle(
          color = Color.Red,
          radius = 80f,
          center = center // 'center' is provided automatically by DrawScope
       )

       // 2. Draw a Rectangle using exact coordinates
       drawRect(
          color = Color.Green,
          topLeft = Offset(size.width, size.height),
          size = Size(250f, 200f)
       )

       // 3. Draw a Line
       drawLine(
          color = Color.Blue,
          start = Offset(center.x, center.y),
          end = Offset(center.x+200, center.y),
       )
    }
}

```
### Lab 1.2: Styling, Strokes, and Gradients
#### Lab 1.2.1:  Brush Object

Before moving to complex styling, understand that a `Brush` is the object responsible for "painting" pixels. Unlike a simple `Color`, a `Brush` can define gradients, textures, and patterns.

In Compose, you don't just pass a color; you can pass a `Brush` to any drawing function (like `drawCircle` or `drawRect`) to create sophisticated visual effects.

#### 1. Linear Gradient Brush

A `linearGradient` transitions colors along a straight line. You can define the start and end points using `Offset`.

```kotlin
Canvas(
   modifier = Modifier.fillMaxSize()
) {

   val brush = Brush.linearGradient(
      colors = listOf(Color.Cyan, Color.Blue)
   )

   drawRect(brush = brush)
}

```

#### 2. Radial Gradient Brush

A `radialGradient` radiates colors outward from a center point (like a glow or a 3D sphere effect).

```kotlin
Canvas(modifier = Modifier.size(200.dp)) {
    val brush = Brush.radialGradient(
        colors = listOf(Color.Yellow, Color.Red),
        center = center,
    )
    
    drawCircle(brush = brush)
}

```

#### 3. Sweep Gradient Brush

A `sweepGradient` (often called a "conic" gradient) sweeps colors 360 degrees around a central point, similar to a radar or a color wheel.

```kotlin
Canvas(modifier = Modifier.size(200.dp)) {
   val brush = Brush.sweepGradient(
      colors = listOf(Color.Red, Color.Yellow),
      center = center
   )

   drawCircle(brush = brush)
}

```

#### 4. Vertical/Horizontal Gradient (Shortcut Methods)

Compose provides convenient shortcuts for simple top-to-bottom or left-to-right transitions without needing to define `Offset` coordinates manually.

```kotlin
Canvas(modifier = Modifier.size(200.dp)) {
    // Horizontal: Transitions from left to right automatically
    val horizontalBrush = Brush.horizontalGradient(
        colors = listOf(Color.Black, Color.White)
    )
    
    // Vertical: Transitions from top to bottom automatically
    val verticalBrush = Brush.verticalGradient(
        colors = listOf(Color.Red, Color.Transparent)
    )

    drawRect(brush = verticalBrush)
}

```

---

### Remember:

| Method | Visual Flow | Common Use Case |
| --- | --- | --- |
| **`linearGradient`** | Straight line (diagonal, horiz, vert) | Standard backgrounds and buttons. |
| **`radialGradient`** | Circular (center to edge) | Lighting effects, shadows, or buttons. |
| **`sweepGradient`** | 360° Circular Sweep | Progress spinners or color pickers. |
| **`verticalGradient`** | Top to Bottom | Fading out an image or text background. |

**API Constraint:** When using a `Brush`, you must use the `brush = ...` parameter in drawing functions instead of the `color = ...` parameter. You cannot use both at the same time.


#### Lab 1.2.2:  different styles
**Step 1:** Modify your `ShapesScreen` to include `Stroke` styles and `Brush` gradients. You will need to import `androidx.compose.ui.graphics.drawscope.Stroke` and `androidx.compose.ui.graphics.Brush`.

```kotlin
@Composable
fun StyledShapesScreen() {
    Canvas(modifier = Modifier.fillMaxSize()) {

       // A circle with just an outline (Stroke)
       drawCircle(
          color = Color.Blue,
          style = Stroke(width = 12f) // Defines the thickness of the outline
       )
    }
}

```

### Lab 1.3: Transformations and paths
#### Lab 1.3.1: simple Transformations
**Objective:** Draw complex custom geometry and manipulate the Canvas grid.

1. Scaling
   The scale transformation expands or shrinks everything drawn inside its block. You can scale X and Y independently.
```kotlin
Canvas(modifier = Modifier.fillMaxSize()) {
    // scaleX = 10f makes the circle 10 times wider (becoming an oval)
    // scaleY = 15f makes it 15 times taller
    scale(scaleX = 10f, scaleY = 15f) {
        drawCircle(
            color = Color.Blue, 
            radius = 20.dp.toPx()
        )
    }
}
```
NOTE: The radius remains 20dp in code, but it appears massive on screen because the coordinate system itself was stretched.

2. Translation
   translate moves the origin (0,0) to a new position. It is the best way to move groups of shapes together.
```kotlin
Canvas(modifier = Modifier.fillMaxSize()) {
   // Moves the drawing start point 100 pixels right and 300 pixels up
   translate(left = 100f, top = -300f) {
      drawCircle(
         color = Color.Blue,
         radius = 200.dp.toPx()
      )
   }
} 
```
NOTE: Positive left moves right; negative top moves up. This is useful for "panning" a camera across a drawing.

3. Rotation
   rotate spins the coordinate system. By default, it rotates around the center of the current canvas.
```kotlin
Canvas(modifier = Modifier.fillMaxSize()) {
    // Rotates the grid 45 degrees clockwise
    rotate(degrees = 45f) {
        drawRect(
            color = Color.Gray,
            topLeft = Offset(x = size.width / 3f, y = size.height / 3f),
            size = size / 3f
        )
    }
}
```
NOTE: The rectangle is defined with standard coordinates, but because the "paper" was turned 45 degrees before drawing, the rectangle appears diamond-shaped.
#### Lab 1.3.2: combined Transformations
When you nest rotate { scale { ... } }, it can become hard to read. withTransform allows you to chain these operations. This is highly efficient because Compose combines them into a single mathematical matrix.
```kotlin
Canvas(modifier = Modifier.fillMaxSize()) {
   withTransform({
      translate(left = size.width / 5F)
      rotate(degrees = 45F)
   }) {
      drawRect(
         color = Color.Gray,
         topLeft = Offset(x = size.width / 3F, y = size.height / 3F),
         size = size / 3F
      )
   }
}
```
NOTE: These approach Keeps all coordinate changes in one configuration block.

and maintain Order because In graphics, "Rotate then Translate" gives a different result than "Translate then Rotate." `withTransform` makes the sequence of operations clear.
#### Lab 1.3.3 : Custom Paths
custom shapes  aren't standard circles or squares (like triangles or stars).
```kotlin
@Composable
fun PathLab() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = Path().apply {
            moveTo(size.width / 2, 100f)      // Start at top middle
            lineTo(100f, size.height - 100f)  // Line to bottom left
            lineTo(size.width - 100f, size.height - 100f) // Line to bottom right
            close() // Draw line back to the start (creates a triangle)
        }

        drawPath(
            path = path,
            color = Color.Cyan,
            style = Stroke(width = 5f)
        )
    }
}
```

### Lab 1.4:  State-Driven Animation
create "living" graphics. In Compose, you don't "move" an object; you change a value over time, and the Canvas redraws itself to reflect that value.

Description: We use rememberInfiniteTransition to create a value that oscillates between 50f and 150f. Because this value is a State, the Canvas block is automatically notified to redraw every time the value changes (usually 60 or 120 times per second).

```kotlin
@Composable
fun AnimatedCircleLab() {
    // 1. Define the transition (the animation engine)
    val transition = rememberInfiniteTransition(label = "pulse")
    
    // 2. Define the animated value (the 'state')
    val animatedRadius by transition.animateFloat(
        initialValue = 50f,
        targetValue = 150f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000), // 1 second duration
            repeatMode = RepeatMode.Reverse
        ),
        label = "radius"
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        // 3. Draw using the animated state
        drawCircle(
            color = Color.Red,
            radius = animatedRadius, // This triggers a redraw whenever it changes
            center = center
        )
    }
}
```

### Lab 1.5:   Gesture & Touch Interaction
 Capture user input to make the graphics interactive.

- To capture touch, we use the pointerInput modifier. The detectTapGestures function gives us an Offset (the exact X and Y coordinate where the finger touched). We store this in a mutableStateOf variable.
```kotlin


@Composable
fun InteractiveAnimatedScreen() {
    // 1. Setup Touch State
    var touchPoint by remember { mutableStateOf(Offset(500f, 500f)) }

    // 2. Setup Animation State
    val transition = rememberInfiniteTransition(label = "pulse")
    val animatedRadius by transition.animateFloat(
        initialValue = 50f,
        targetValue = 150f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "radius"
    )

    // 3. Draw and listen for touch
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    touchPoint = offset // Update state on tap
                }
            }
    ) {
        // Because 'animatedRadius' and 'touchPoint' are states, 
        // this circle redraws automatically, creating fluid animation!
        drawCircle(
            color = Color.Red.copy(alpha = 0.5f), // Slightly transparent
            radius = animatedRadius,
            center = touchPoint
        )
    }
}

```
NOTE : The Canvas itself doesn't "listen" for touch; the Modifier attached to it does. When the state variable touchPoint updates, the Canvas recomposes.

---

## Part 2: Multimedia & Camera Interoperability

