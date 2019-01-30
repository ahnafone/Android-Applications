/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public String reviewOrder(View view) {
        int price = 5;

        EditText text = (EditText) findViewById(R.id.name);
        String summary = text.getText().toString() + " wants coffee\nQuantity: " + quantity;

        CheckBox box = (CheckBox) findViewById(R.id.whipped_cream);
        if (box.isChecked()) {
            summary += "\n+ whipped cream";
            price++;
        }

        box = (CheckBox) findViewById(R.id.chocolate);
        if (box.isChecked()) {
            summary += "\n+ chocolate syrup";
            price += 2;
        }

        summary += "\nTotal: $" + (quantity * price) + "\nThank You!";
        displayMessage(summary);

        return summary;
    }

    public void sendOrder (View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java");
        intent.putExtra(Intent.EXTRA_TEXT, reviewOrder(view));
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void increment(View view) {
        if (quantity < 99) {
            quantity += 1;
            displayQuantity(quantity);
        }//if
        else
            Toast.makeText(this, "You cannot order more than a 100 coffees!", Toast.LENGTH_SHORT).show();
    }

    public void decrement(View view) {
        if (quantity > 1) {
            quantity -= 1;
            displayQuantity(quantity);
        }//if
        else
            Toast.makeText(this, "You cannot order less than one coffee!", Toast.LENGTH_SHORT).show();
    }
}