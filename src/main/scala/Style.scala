import scalacss.DevDefaults._

object Style extends StyleSheet.Standalone {
import dsl._

  "div.std" - (
          margin(12 px, auto),
          textAlign.left,
          cursor.pointer,

          &.hover -
          cursor.zoomIn,

          media.not.handheld.landscape.maxWidth(640 px) -
          width(400 px),

          &("span") -
          color.red
          )

          "h1".firstChild -
          fontWeight.bold

          for (i <- 0 to 3)
          s".indent-$i" -
          paddingLeft(i * 2.ex)
          }